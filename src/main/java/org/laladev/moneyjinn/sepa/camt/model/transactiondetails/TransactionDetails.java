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

package org.laladev.moneyjinn.sepa.camt.model.transactiondetails;

public class TransactionDetails {
	private BankTransactionCode bankTransactionCode;
	private RelatedParties relatedParties;
	private RemittanceInformation remittanceInformation;

	public final BankTransactionCode getBankTransactionCode() {
		return this.bankTransactionCode;
	}

	public final void setBankTransactionCode(final BankTransactionCode bankTransactionCode) {
		this.bankTransactionCode = bankTransactionCode;
	}

	public final RelatedParties getRelatedParties() {
		return this.relatedParties;
	}

	public final void setRelatedParties(final RelatedParties relatedParties) {
		this.relatedParties = relatedParties;
	}

	public final RemittanceInformation getRemittanceInformation() {
		return this.remittanceInformation;
	}

	public final void setRemittanceInformation(final RemittanceInformation remittanceInformation) {
		this.remittanceInformation = remittanceInformation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.bankTransactionCode == null) ? 0 : this.bankTransactionCode.hashCode());
		result = prime * result + ((this.relatedParties == null) ? 0 : this.relatedParties.hashCode());
		result = prime * result + ((this.remittanceInformation == null) ? 0 : this.remittanceInformation.hashCode());
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
		final TransactionDetails other = (TransactionDetails) obj;
		if (this.bankTransactionCode == null) {
			if (other.bankTransactionCode != null) {
				return false;
			}
		} else if (!this.bankTransactionCode.equals(other.bankTransactionCode)) {
			return false;
		}
		if (this.relatedParties == null) {
			if (other.relatedParties != null) {
				return false;
			}
		} else if (!this.relatedParties.equals(other.relatedParties)) {
			return false;
		}
		if (this.remittanceInformation == null) {
			if (other.remittanceInformation != null) {
				return false;
			}
		} else if (!this.remittanceInformation.equals(other.remittanceInformation)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("TransactionDetails [bankTransactionCode=");
		builder.append(this.bankTransactionCode);
		builder.append(", relatedParties=");
		builder.append(this.relatedParties);
		builder.append(", remittanceInformation=");
		builder.append(this.remittanceInformation);
		builder.append("]");
		return builder.toString();
	}

}
