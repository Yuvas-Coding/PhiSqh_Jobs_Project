package my.com.cmg.iwp.util;

import java.util.Map;

import org.zkoss.zul.Messagebox;

public class ExceptionMessage {
	
	public static final int YES				= Messagebox.YES;
	public static final int NO				= Messagebox.NO;
	public static final int CANCEL			= Messagebox.CANCEL;
	
	public static final String CONFIRM		= "CONFIRM";
	public static final String CONFIRMYN		= "CONFIRMYN";
	public static final String INFORM		= "INFORM";
	public static final String ERROR		= "ERROR";
	public static final String ALERT		= "ALERT";
	public static final String WARN			= "WARN";
	
	public static int showMessage(String messageCode,String...params) {
		Message message = getMessageMap().get(messageCode);
		String messageText = messageCode;
		if(message != null) {
			messageText = getDynamicMessageContent(message.getMessage(),params);
			
			if (ExceptionMessage.ERROR.equals(message.getMessageType())) {
				return Messagebox.show(messageText, message.getTitle(), Messagebox.OK, Messagebox.ERROR);
			} else if (ExceptionMessage.CONFIRM.equals(message.getMessageType())) {
				return Messagebox.show(messageText, message.getTitle(), Messagebox.YES | Messagebox.NO | Messagebox.CANCEL, Messagebox.QUESTION);
			} else if (ExceptionMessage.INFORM.equals(message.getMessageType())) {
				return Messagebox.show(messageText, message.getTitle(), Messagebox.OK, Messagebox.INFORMATION);
			} else if (ExceptionMessage.ALERT.equals(message.getMessageType())) {
				return Messagebox.show(messageText, message.getTitle(), Messagebox.OK, Messagebox.ERROR);
			} else if (ExceptionMessage.WARN.equals(message.getMessageType())) {
				return Messagebox.show(messageText, message.getTitle(), Messagebox.OK, Messagebox.ERROR);
			} else if (ExceptionMessage.CONFIRMYN.equals(message.getMessageType())) {
				return Messagebox.show(messageText, message.getTitle(), Messagebox.YES | Messagebox.NO , Messagebox.QUESTION);
			}
			
			return Messagebox.show(messageText, message.getTitle(), Messagebox.OK, Messagebox.INFORMATION);
		} else
			return Messagebox.show(messageText, messageCode, Messagebox.OK, Messagebox.INFORMATION);
	}
	
	private static String getDynamicMessageContent(String message,String...params) {
		String messageToDisplay = message;//.replaceAll("\\bfor\\b", "of");
		if(params.length!=0 && messageToDisplay.contains("{")){
			for (int i=1; i<=params.length; i++) {
				messageToDisplay = messageToDisplay.replace("{"+i+"}", params[i-1]);
			}
		}
		return messageToDisplay.replaceAll("\\{[0-9]+\\}", "");
	}
	
	public static Map<String, Message> getMessageMap() {
		Map<String, Message> messageMap = MyApplicationContextAware.getMessageMap();
		return messageMap;
	}
}
