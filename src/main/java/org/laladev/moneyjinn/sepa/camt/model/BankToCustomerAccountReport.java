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

public class BankToCustomerAccountReport {
	private GroupHeader groupHeader;
	private Report report;

	public final GroupHeader getGroupHeader() {
		return this.groupHeader;
	}

	public final void setGroupHeader(final GroupHeader groupHeader) {
		this.groupHeader = groupHeader;
	}

	public final Report getReport() {
		return this.report;
	}

	public final void setReport(final Report report) {
		this.report = report;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.groupHeader == null) ? 0 : this.groupHeader.hashCode());
		result = prime * result + ((this.report == null) ? 0 : this.report.hashCode());
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
		final BankToCustomerAccountReport other = (BankToCustomerAccountReport) obj;
		if (this.groupHeader == null) {
			if (other.groupHeader != null) {
				return false;
			}
		} else if (!this.groupHeader.equals(other.groupHeader)) {
			return false;
		}
		if (this.report == null) {
			if (other.report != null) {
				return false;
			}
		} else if (!this.report.equals(other.report)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("BankToCustomerAccountReport [groupHeader=");
		builder.append(this.groupHeader);
		builder.append(", report=");
		builder.append(this.report);
		builder.append("]");
		return builder.toString();
	}

}
