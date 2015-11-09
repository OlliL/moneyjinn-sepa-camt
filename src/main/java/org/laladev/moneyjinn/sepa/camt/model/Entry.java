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

import org.laladev.moneyjinn.sepa.camt.model.common.Amount;

public class Entry {
	private Amount amount;
	private CreditDebitCode creditDebitIndicator;
	private EntryStatus2Code status;
	private Calendar bookingDate;
	private Calendar valueDate;
	private EntryDetails entryDetails;

	public final Amount getAmount() {
		return this.amount;
	}

	public final void setAmount(final Amount amount) {
		this.amount = amount;
	}

	public final CreditDebitCode getCreditDebitIndicator() {
		return this.creditDebitIndicator;
	}

	public final void setCreditDebitIndicator(final CreditDebitCode creditDebitIndicator) {
		this.creditDebitIndicator = creditDebitIndicator;
	}

	public final EntryStatus2Code getStatus() {
		return this.status;
	}

	public final void setStatus(final EntryStatus2Code status) {
		this.status = status;
	}

	public final Calendar getBookingDate() {
		return this.bookingDate;
	}

	public final void setBookingDate(final Calendar bookingDate) {
		this.bookingDate = bookingDate;
	}

	public final Calendar getValueDate() {
		return this.valueDate;
	}

	public final void setValueDate(final Calendar valueDate) {
		this.valueDate = valueDate;
	}

	public final EntryDetails getEntryDetails() {
		return this.entryDetails;
	}

	public final void setEntryDetails(final EntryDetails entryDetails) {
		this.entryDetails = entryDetails;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.amount == null) ? 0 : this.amount.hashCode());
		result = prime * result + ((this.bookingDate == null) ? 0 : this.bookingDate.hashCode());
		result = prime * result + ((this.creditDebitIndicator == null) ? 0 : this.creditDebitIndicator.hashCode());
		result = prime * result + ((this.entryDetails == null) ? 0 : this.entryDetails.hashCode());
		result = prime * result + ((this.status == null) ? 0 : this.status.hashCode());
		result = prime * result + ((this.valueDate == null) ? 0 : this.valueDate.hashCode());
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
		final Entry other = (Entry) obj;
		if (this.amount == null) {
			if (other.amount != null) {
				return false;
			}
		} else if (!this.amount.equals(other.amount)) {
			return false;
		}
		if (this.bookingDate == null) {
			if (other.bookingDate != null) {
				return false;
			}
		} else if (!this.bookingDate.equals(other.bookingDate)) {
			return false;
		}
		if (this.creditDebitIndicator != other.creditDebitIndicator) {
			return false;
		}
		if (this.entryDetails == null) {
			if (other.entryDetails != null) {
				return false;
			}
		} else if (!this.entryDetails.equals(other.entryDetails)) {
			return false;
		}
		if (this.status != other.status) {
			return false;
		}
		if (this.valueDate == null) {
			if (other.valueDate != null) {
				return false;
			}
		} else if (!this.valueDate.equals(other.valueDate)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("Entry [amount=");
		builder.append(this.amount);
		builder.append(", creditDebitIndicator=");
		builder.append(this.creditDebitIndicator);
		builder.append(", status=");
		builder.append(this.status);
		builder.append(", bookingDate=");
		builder.append(this.bookingDate);
		builder.append(", valueDate=");
		builder.append(this.valueDate);
		builder.append(", entryDetails=");
		builder.append(this.entryDetails);
		builder.append("]");
		return builder.toString();
	}

}
