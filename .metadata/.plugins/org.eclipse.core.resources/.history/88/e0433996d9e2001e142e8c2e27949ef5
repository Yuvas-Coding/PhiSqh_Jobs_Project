package my.com.cmg.iwp.backend.model.integration.decorator;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import my.com.cmg.iwp.maintenance.model.NotificationHdrV1823;

@XmlRootElement(name = "SpubHdrIntList")
public class NotificationsHdrIntListV1823 {
	private List<NotificationHdrV1823> notificationHdrInts = new ArrayList<NotificationHdrV1823>();	
	
	public NotificationsHdrIntListV1823() {
		super();
	}

	@XmlElement(name = "NotificationHdr")
	public List<NotificationHdrV1823> getNotificationHdrInts() {
		return notificationHdrInts;
	}

	public void setNotificationHdrInts(List<NotificationHdrV1823> notificationHdrInts) {
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
		NotificationsHdrIntListV1823 other = (NotificationsHdrIntListV1823) obj;
		if (notificationHdrInts == null) {
			if (other.notificationHdrInts != null)
				return false;
		} else if (!notificationHdrInts.equals(other.notificationHdrInts))
			return false;
		return true;
	}

}
