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

package org.laladev.moneyjinn.sepa.camt.model.transactiondetails;

import org.laladev.moneyjinn.sepa.camt.model.common.party.Creditor;
import org.laladev.moneyjinn.sepa.camt.model.common.party.Debtor;

public class RelatedParties {
	private Creditor creditor;
	private Debtor debtor;

	public final Creditor getCreditor() {
		return this.creditor;
	}

	public final void setCreditor(final Creditor creditor) {
		this.creditor = creditor;
	}

	public final Debtor getDebtor() {
		return this.debtor;
	}

	public final void setDebtor(final Debtor debtor) {
		this.debtor = debtor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.creditor == null) ? 0 : this.creditor.hashCode());
		result = prime * result + ((this.debtor == null) ? 0 : this.debtor.hashCode());
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
		final RelatedParties other = (RelatedParties) obj;
		if (this.creditor == null) {
			if (other.creditor != null) {
				return false;
			}
		} else if (!this.creditor.equals(other.creditor)) {
			return false;
		}
		if (this.debtor == null) {
			if (other.debtor != null) {
				return false;
			}
		} else if (!this.debtor.equals(other.debtor)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("RelatedParties [creditor=");
		builder.append(this.creditor);
		builder.append(", debtor=");
		builder.append(this.debtor);
		builder.append("]");
		return builder.toString();
	}

}
