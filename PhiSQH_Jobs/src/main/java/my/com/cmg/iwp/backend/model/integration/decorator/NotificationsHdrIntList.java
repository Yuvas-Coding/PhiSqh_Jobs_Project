package my.com.cmg.iwp.backend.model.integration.decorator;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import my.com.cmg.iwp.maintenance.model.NotificationHdr;

@XmlRootElement(name = "SpubHdrIntList")
public class NotificationsHdrIntList {
	private List<NotificationHdr> notificationHdrInts = new ArrayList<NotificationHdr>();	
	
	public NotificationsHdrIntList() {
		super();
	}

	@XmlElement(name = "NotificationHdr")
	public List<NotificationHdr> getNotificationHdrInts() {
		return notificationHdrInts;
	}

	public void setNotificationHdrInts(List<NotificationHdr> notificationHdrInts) {
		this.notificationHdrInts = notificationHdrInts;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((notificationHdrInts == null) ? 0 : notificationHdrInts.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NotificationsHdrIntList other = (NotificationsHdrIntList) obj;
		if (notificationHdrInts == null) {
			if (other.notificationHdrInts != null)
				return false;
		} else if (!notificationHdrInts.equals(other.notificationHdrInts))
			return false;
		return true;
	}

}
