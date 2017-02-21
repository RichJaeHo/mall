package com.shopping.mall.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 프로그래밍의 편의를 위한 클래스.<br>
 * 각종 편의를 제공한다.
 * @author Toran
 * @since 2016-11-01
 */
public class Util {
	
	private static final String DELETED = "D";
	
	/**
	 * String의 값이 null일 경우 이를 공백으로 바꾸어 리턴한다.
	 * @author Toran
	 * @param String
	 * @return String
	 */
	public static String nullToString(String str) {
		if (str == null) {
			return "";
		}
		return str;
	}
	
	/**
	 * String의 값에 공백이 있을 경우 양단의 공백을 제거하여 리턴한다.
	 * 이 경우 공백문자열은 빈 문자열로 리턴한다.
	 * @author Toran
	 * @param String
	 * @return String
	 */
	public static String trim(String str) {
		return Util.nullToString(str).trim();
	}
	
	/**
	 * 텍스트 컨텐츠를 html 페이지에 보여줄 경우 jsp에서 escape 문자를 변경하지 말고<br>
	 * 먼저 이 메소드를 거친 html 문자열을 보여주도록 한다.
	 * @param content HTML 문서에 보여 줄 내용
	 * @return Escape 문자를 변환한 텍스트
	 * @author Toran
	 * @since 2016-11-09
	 */
	public static String textToHtml(String content, String deleted) {
		if (content == null) {
			return "";
		}
		if (DELETED.equals(deleted)) {
			return "[삭제됨]";
		}
		content = content.replace("&", "&amp;")
						 .replace("<", "&lt;")
						 .replace(">", "&gt;")
						 .replace("\n", "<br>");
		return content;
	}
	
	/**
	 * 삭제된 컨텐츠인지 아닌지 판단한다. 이 컨텐츠는 HTML 컨텐츠이므로 escape 문자를 변경하지 않는다.
	 * @param content HTML 문서에 보여 줄 내용
	 * @return Escape 문자를 변환한 텍스트
	 * @author Toran
	 * @since 2016-11-09
	 */
	public static String determineDeleted(String content, String deleted) {
		if (content == null) {
			return "";
		}
		if (DELETED.equals(deleted)) {
			return "[삭제됨]";
		}
		return content;
	}
	
	/**
	 * 게시글의 답글의 경우 Depth만큼 들여쓰기가 되므로,<br>
	 * 그 들여쓰기만큼의 공백을 리턴한다.
	 * @author Toran
	 * @param depth 들여쓰기 단계
	 * @return 들여쓰기 공백
	 * @since 2016-11-09
	 */
	public static String getDepthString(int depth) {
		String replyDepth = "";
		for (int i = 0; i < depth; i++) {
			replyDepth += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
		}
		return replyDepth;
	}
	
	/**
	 * 문자열을 숫자로 바꾼다. <br>
	 * NumberFormatException을 피하기 위하여 문자열이 null일 경우 0을 리턴한다.\
	 * @author Toran
	 * @param number parse할 숫자
	 * @return parse한 숫자
	 * @since 2016-11-10
	 */
	public static int toInt(String number) {
		int num = 0;
		if (Util.trim(number).equals("")) {
			num = 0;
		} else {
			try {
				num = Integer.parseInt(number);
			} catch (NumberFormatException ne) {
				ne.printStackTrace();
			}
		}
		return num;
	}
	
	/** 
	 * 지정된 암호화 알고리즘에 따라 문자열 데이터를 암호화 처리
	 * 
	 * @author lsangk
	 * @return parse한 숫자
	 * @since 2016-11-12
	 * @param source 암호화 대상 문자열
	 * @param algorithm 암호화 알고리즘 문자열 (SHA-1, MD5, SHA-256 ...)
	 * @return 암호화된 데이터
	 */
	public static byte[] getHashedData(String source, String algorithm) {
		
		byte[] hashedData = null;
		
		try {
			//암호화 처리 인스턴스 생성
			MessageDigest md = 
				MessageDigest.getInstance(algorithm);
			hashedData = md.digest(source.getBytes());//지정된 알고리즘으로 암호화
		} catch (NoSuchAlgorithmException ex) {	
			hashedData = null;
		}
		
		return hashedData;
	}
	
	/**
	 * 문자열을 암호화 알고리즘에 따라 암호화 하고 결과를 문자열로 변환
	 * @author lsangk
	 * @return parse한 숫자
	 * @since 2016-11-12
	 * @param source
	 * @param algorithm
	 * @return
	 */
	public static String getHashedString(String source, String algorithm) {
		
		byte[] hashedData = getHashedData(source, algorithm);
		
		if (hashedData == null) return null;
		 
		String hashedString = "";
		for (int i = 0; i < hashedData.length; i++) {
			String hexString = 
				Integer.toHexString((int)hashedData[i] & 0x000000ff);
			if (hexString.length() < 2)
				hexString = "0" + hexString;
			
			hashedString += hexString;
		}
		
		return hashedString;
	}
	
	/**
	 * 고유한 파일명을 만든다.
	 * @author Toran
	 * @param fileName 파일명
	 * @return 고유한 파일명
	 * @since 2011-11-13
	 */
	public static String getUniqueFileName(String fileName) {   
        String ext = fileName.substring(fileName.lastIndexOf("."));        
        String name = UUID.randomUUID().toString();
        return name + ext;
    }
	
	/**
	 * 한글 깨짐을 방지한다.
	 * @author Toran
	 * @param str 인코딩을 바꾸고자 하는 문자열
	 * @return 인코딩을 바꾼 문자열
	 * @since 2016-11-15
	 */
	public static String getEncodedString(String str) {
		String encodedStr = null;
		try {
			encodedStr = new String(str.getBytes("euc-kr"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return encodedStr;
	}
	
	/**
	 * 문자열을 long 타입으로 변환한다.
	 * @author Toran
	 * @param number parse할 문자열
	 * @return long
	 * @since 2016-11-16
	 */
	public static long toLong(String number) {
		long num = 0;
		if (Util.trim(number).equals("")) {
			num = 0L;
		} else {
			try {
				num = Long.parseLong(number);
			} catch (NumberFormatException ne) {
				ne.printStackTrace();
			}
		}
		return num;
	}
	
	/**
	 * 사용자가 인증된 사용자인지를 리턴한다.
	 * @author Toran
	 * @param req HttpServletRequest
	 * @param memberId 아이디
	 * @return 인증되었는지 여부
	 * @since 2016-11-17
	 */
//	public static boolean isAuthenticated(HttpServletRequest req, String memberId) {
//		boolean authenticated = false;
//		HttpSession session = req.getSession();
//		String loginId = (String) session.getAttribute("loginId"); // key는 변경될 수 있음.
//		authenticated = Util.nullToString(loginId).equals(memberId);
//		return authenticated;
//	}
	
	/**
	 * 인증된 또는 인증되지 않은 사용자가 권한이 있는지를 체크한다.
	 * @author Toran
	 * @param req HttpServletRequest
	 * @param authorize 권한
	 * @return 권한이 있는지 여부
	 * @since 2016-11-17
	 */
//	public static boolean isAuthorized(HttpServletRequest req, String authorize) {
//		boolean authorized = false;
//		HttpSession session = req.getSession();
//		String author = (String) session.getAttribute("authorized");
//		authorized = Util.nullToString(author).equals(authorize);
//		return authorized;
//	}
	
	/**
	 * 사용자의 권한이 해당 작업에 필요한 권한과 같거나 이보다 큰지를 리턴한다.
	 * @author Toran
	 * @param req HttpServletRequest
	 * @param authorize 사용자의 권한
	 * @return 권한이 큰지 여부
	 * @since 2016-11-17
	 */
	public static boolean hasAuthors(HttpServletRequest req, String authorize) {
		HttpSession session = req.getSession();
		int sessionAuthor = Util.toInt((String) session.getAttribute("authorized"));
		return sessionAuthor >= Util.toInt(authorize);
	}
	
	/**
	 * 게시글의 등록시간과 현재시각의 차이를 구한다.
	 * @author Toran
	 * @param timeDiffer DB에서 조회된 시간차이 문자열 xxx일 yy:zz:ww.0000의 형식
	 * @return 시간 차이
	 * @since 2016-12-30
	 */
	public static String getTimeDifferences(String timeDiffer) {
		if (timeDiffer == null) {
			return "Andromeda Forever";
		}
		String[] td = timeDiffer.split(" ");
		int days = Integer.parseInt(td[0]);
		String differsFromNow = "";
		try {
			if (days > 0) {
				if (days / 365 > 0) {
					differsFromNow = (days / 365) + "년 전";
				} else if (days / 30 > 0) {
					differsFromNow = (days / 30) + "월 전";
				} else {
					differsFromNow = days + "일 전";
				}
			} else {
				String[] time = td[1].split(":");
				if (Integer.parseInt(time[0]) > 0) {
					differsFromNow = time[0] + "시간 전";
				} else if (Integer.parseInt(time[1]) > 0) {
					differsFromNow = time[1] + "분 전";
				} else {
					differsFromNow = time[2].split(".")[0] + "초 전";
				}
			}
		} catch (Exception e) {
			return "방금 전";
		}
		return differsFromNow;
	}
	
	/**
	 * Date 포맷을 날짜 형식의 String 타입으로 변환한다.
	 * @param date
	 * @return
	 */
	public static String toStringAsDateFormat(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	
	/**
	 * Date 포맷을 날짜, 시간 형식의 String 타입으로 변환한다.
	 * @param date
	 * @return
	 */
	public static String toStringAsTimeFormat(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
}
