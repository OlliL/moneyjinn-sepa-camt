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

package org.laladev.moneyjinn.sepa.camt.parser;

import org.laladev.moneyjinn.sepa.camt.model.CreditDebitCode;
import org.laladev.moneyjinn.sepa.camt.model.Entry;
import org.laladev.moneyjinn.sepa.camt.model.EntryStatus2Code;
import org.laladev.moneyjinn.sepa.camt.util.DOMUtil;
import org.w3c.dom.Element;

public class NtryParser {
	private final NtryDtlsParser ntryDtlsParser = new NtryDtlsParser();
	private final AmtParser amtParser = new AmtParser();

	public Entry parse(final Element ntry) {
		final Entry entry = new Entry();

		final Element ntryDtls = DOMUtil.getElementByName(ntry, "NtryDtls");
		final Element amt = DOMUtil.getElementByName(ntry, "Amt");

		final Element bookgDt = DOMUtil.getElementByName(ntry, "BookgDt");
		final Element bookgDtDtTm = DOMUtil.getElementByName(bookgDt, "DtTm");
		final Element bookgDtDt = DOMUtil.getElementByName(bookgDt, "Dt");

		final Element valDt = DOMUtil.getElementByName(ntry, "ValDt");
		final Element valDtDtTm = DOMUtil.getElementByName(valDt, "DtTm");
		final Element valDtDt = DOMUtil.getElementByName(valDt, "Dt");

		final String cdtDbtInd = DOMUtil.getElementValueByName(ntry, "CdtDbtInd");
		final String sts = DOMUtil.getElementValueByName(ntry, "Sts");

		entry.setEntryDetails(this.ntryDtlsParser.parse(ntryDtls));
		entry.setAmount(this.amtParser.parse(amt));
		entry.setCreditDebitIndicator(CreditDebitCode.fromString(cdtDbtInd));
		entry.setStatus(EntryStatus2Code.fromString(sts));

		if (bookgDtDtTm != null) {
			entry.setBookingDate(DOMUtil.getDateTime(bookgDtDtTm));
		} else {
			entry.setBookingDate(DOMUtil.getDateTime(bookgDtDt));
		}

		if (valDtDtTm != null) {
			entry.setValueDate(DOMUtil.getDateTime(valDtDtTm));
		} else {
			entry.setValueDate(DOMUtil.getDateTime(valDtDt));
		}

		return entry;

	}
}
