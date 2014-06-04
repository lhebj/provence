/* Copyright 2006-2008 AbleSky, Inc. All rights reserved.
This program is an unpublished work fully protected by the United States,
P.R. China and International copyright laws and is considered a trade secret
belonging to AbleSky, Inc. It is not to be divulged or used by parties who
have not received written authorization from AbleSky, Inc.
AbleSky, Inc.
539 Chiquita Ave
Mountain View, CA 94041, USA
http://www.ablesky.com
Email: support@ablesky.com
Copyright 2006-2008 AbleSky, Inc. All rights reserved.
 */
package com.provence.messagefactory;

/**
 * @author lhe E-mail:lhe@ablesky.com
 */
public class MailBody implements java.io.Serializable {
	private String to;
	private String personal;
	private String from;
	private String subject;
	private String text;
	private int type;
	private boolean isActivated;
	private boolean willSend;

	public boolean isWillSend() {
		return willSend;
	}

	public void setWillSend(boolean willSend) {
		this.willSend = willSend;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getPersonal() {
		return personal;
	}

	public void setPersonal(String personal) {
		this.personal = personal;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
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
		final MailBody other = (MailBody) obj;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		return true;
	}

	public boolean isActivated() {
		return isActivated;
	}

	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}


}
