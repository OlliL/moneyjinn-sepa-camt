//
// Copyright (c) 2015 Oliver Lehmann <oliver@laladev.org>
// All rights reserved.
//
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions
// are met:
// 1. Redistributions of source code must retain the above copyright
// notice, this list of conditions and the following disclaimer
// 2. Redistributions in binary form must reproduce the above copyright
// notice, this list of conditions and the following disclaimer in the
// documentation and/or other materials provided with the distribution.
//
// THIS SOFTWARE IS PROVIDED BY THE AUTHOR AND CONTRIBUTORS ``AS IS'' AND
// ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
// IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
// ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR OR CONTRIBUTORS BE LIABLE
// FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
// DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
// OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
// HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
// LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
// OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
// SUCH DAMAGE.
//

package org.laladev.moneyjinn.sepa.camt.model;

import java.util.Calendar;

import org.laladev.moneyjinn.sepa.camt.model.common.party.MessageRecipient;

public class GroupHeader {
	private String messageIdentification;
	private Calendar creationDateTime;
	private MessageRecipient messageRecipient;

	public final String getMessageIdentification() {
		return this.messageIdentification;
	}

	public final void setMessageIdentification(final String messageIdentification) {
		this.messageIdentification = messageIdentification;
	}

	public final Calendar getCreationDateTime() {
		return this.creationDateTime;
	}

	public final void setCreationDateTime(final Calendar creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

	public final MessageRecipient getMessageRecipient() {
		return this.messageRecipient;
	}

	public final void setMessageRecipient(final MessageRecipient messageRecipient) {
		this.messageRecipient = messageRecipient;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.creationDateTime == null) ? 0 : this.creationDateTime.hashCode());
		result = prime * result + ((this.messageIdentification == null) ? 0 : this.messageIdentification.hashCode());
		result = prime * result + ((this.messageRecipient == null) ? 0 : this.messageRecipient.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final GroupHeader other = (GroupHeader) obj;
		if (this.creationDateTime == null) {
			if (other.creationDateTime != null) {
				return false;
			}
		} else if (!this.creationDateTime.equals(other.creationDateTime)) {
			return false;
		}
		if (this.messageIdentification == null) {
			if (other.messageIdentification != null) {
				return false;
			}
		} else if (!this.messageIdentification.equals(other.messageIdentification)) {
			return false;
		}
		if (this.messageRecipient == null) {
			if (other.messageRecipient != null) {
				return false;
			}
		} else if (!this.messageRecipient.equals(other.messageRecipient)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("GroupHeader [messageIdentification=");
		builder.append(this.messageIdentification);
		builder.append(", creationDateTime=");
		builder.append(this.creationDateTime);
		builder.append(", messageRecipient=");
		builder.append(this.messageRecipient);
		builder.append("]");
		return builder.toString();
	}

}
