//
// Copyright (c) 2015 Oliver Lehmann <lehmann@ans-netz.de>
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
import java.util.List;

public class Report {
	private String identification;
	private Calendar creationDateTime;
	private Account account;
	private Balance balance;
	private List<Entry> entries;
	private String additionalReportInformation;

	public final String getIdentification() {
		return this.identification;
	}

	public final void setIdentification(final String identification) {
		this.identification = identification;
	}

	public final Calendar getCreationDateTime() {
		return this.creationDateTime;
	}

	public final void setCreationDateTime(final Calendar creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

	public final Account getAccount() {
		return this.account;
	}

	public final void setAccount(final Account account) {
		this.account = account;
	}

	public final Balance getBalance() {
		return this.balance;
	}

	public final void setBalance(final Balance balance) {
		this.balance = balance;
	}

	public final List<Entry> getEntries() {
		return this.entries;
	}

	public final void setEntries(final List<Entry> entries) {
		this.entries = entries;
	}

	public final String getAdditionalReportInformation() {
		return this.additionalReportInformation;
	}

	public final void setAdditionalReportInformation(final String additionalReportInformation) {
		this.additionalReportInformation = additionalReportInformation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.account == null) ? 0 : this.account.hashCode());
		result = prime * result
				+ ((this.additionalReportInformation == null) ? 0 : this.additionalReportInformation.hashCode());
		result = prime * result + ((this.balance == null) ? 0 : this.balance.hashCode());
		result = prime * result + ((this.creationDateTime == null) ? 0 : this.creationDateTime.hashCode());
		result = prime * result + ((this.entries == null) ? 0 : this.entries.hashCode());
		result = prime * result + ((this.identification == null) ? 0 : this.identification.hashCode());
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
		final Report other = (Report) obj;
		if (this.account == null) {
			if (other.account != null) {
				return false;
			}
		} else if (!this.account.equals(other.account)) {
			return false;
		}
		if (this.additionalReportInformation == null) {
			if (other.additionalReportInformation != null) {
				return false;
			}
		} else if (!this.additionalReportInformation.equals(other.additionalReportInformation)) {
			return false;
		}
		if (this.balance == null) {
			if (other.balance != null) {
				return false;
			}
		} else if (!this.balance.equals(other.balance)) {
			return false;
		}
		if (this.creationDateTime == null) {
			if (other.creationDateTime != null) {
				return false;
			}
		} else if (!this.creationDateTime.equals(other.creationDateTime)) {
			return false;
		}
		if (this.entries == null) {
			if (other.entries != null) {
				return false;
			}
		} else if (!this.entries.equals(other.entries)) {
			return false;
		}
		if (this.identification == null) {
			if (other.identification != null) {
				return false;
			}
		} else if (!this.identification.equals(other.identification)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("Report [identification=");
		builder.append(this.identification);
		builder.append(", creationDateTime=");
		builder.append(this.creationDateTime);
		builder.append(", account=");
		builder.append(this.account);
		builder.append(", balance=");
		builder.append(this.balance);
		builder.append(", entries=");
		builder.append(this.entries);
		builder.append(", additionalReportInformation=");
		builder.append(this.additionalReportInformation);
		builder.append("]");
		return builder.toString();
	}

}
