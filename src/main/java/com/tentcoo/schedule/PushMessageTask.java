package com.tentcoo.schedule;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.tentcoo.dao.BookListDao;
import com.tentcoo.dao.UserDao;
import com.tentcoo.entity.BookListEntity;
import com.tentcoo.entity.UserEntity;
import com.tentcoo.library.pojo.BookDetail;
import com.tentcoo.library.pojo.BorrowDetail;
import com.tentcoo.message.SendMessage;
import com.tentcoo.service.LibraryService;

@Component
public class PushMessageTask {
	
	private Logger logger = Logger.getLogger(PushMessageTask.class);
	
	@Resource
	UserDao userDao;
	
	@Resource
	BookListDao booklistDao;
	
	@Resource
	LibraryService libraryService;
	
	@Resource
	SendMessage sender;
	
	@Scheduled(cron="0 0 6 * * ?")
	public void pushBookMessage() {
		List<UserEntity> userList = userDao.getAllUserList();
		for(UserEntity user : userList ) {
			List<BookListEntity> res = booklistDao.selectNotReturnByUserId(user.getId());
			int index = 1;
			if(!res.isEmpty()) {
				StringBuffer buf = new StringBuffer();
				for(BookListEntity bookList : res ) {
					if(bookList.getIsBack() == 0 && bookList.getBookSource()!=null) {
						String spm = bookList.getBookSource();
						try {
							byte[] baseByte = Base64.decodeBase64(spm);
							String query = new String(baseByte, "utf-8");
							if (query.startsWith("tentcoo_") && query.endsWith("$$tentcoo_end")) {
								boolean isBack = false;
								query = "http://query.libmill.com" + query.replace("tentcoo_", "").replace("$$tentcoo_end", "");
								BookDetail detail  = libraryService.getBookDetail(query);
								for(BorrowDetail borrowDetails : detail.getBorrows()) {
									if(borrowDetails.getStatus()!=null && borrowDetails.getStatus().equals("可借")) {
										isBack = true;
										break;
									}
								}
								if(isBack) {
									buf.append( index + "."+ detail.getTitle()+" 索书号："+detail.getLibNumber() +"\n");
									bookList.setIsBack(1);
									booklistDao.updateBookList(bookList);
									index ++;
								}
							}
						} catch (Exception e) {
							logger.error("Exception",e);
						}
					}
				}
				if(buf.length() > 0 ) {
					String message = "亲爱的童鞋，您书单中的书籍：\n"+buf.toString()+"其他同学已经归还到图书馆，赶快去图书馆看看啦！";
					sender.sendMessage(message, user);
				}
			}
		}
	}

}
