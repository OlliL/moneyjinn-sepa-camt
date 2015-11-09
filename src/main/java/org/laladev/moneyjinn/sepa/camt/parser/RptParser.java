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

package org.laladev.moneyjinn.sepa.camt.parser;

import java.util.ArrayList;
import java.util.List;

import org.laladev.moneyjinn.sepa.camt.model.Entry;
import org.laladev.moneyjinn.sepa.camt.model.Report;
import org.laladev.moneyjinn.sepa.camt.util.DOMUtil;
import org.w3c.dom.Element;

public class RptParser {

	private final AcctParser acctParser = new AcctParser();
	private final BalParser balParser = new BalParser();
	private final NtryParser ntryParser = new NtryParser();

	public Report parse(final Element rpt) {
		final Report report = new Report();

		final String id = DOMUtil.getElementValueByName(rpt, "Id");
		final Element creDtTm = DOMUtil.getElementByName(rpt, "CreDtTm");
		final Element acct = DOMUtil.getElementByName(rpt, "Acct");
		final Element bal = DOMUtil.getElementByName(rpt, "Bal");
		final List<Element> ntryList = DOMUtil.getElementsByName(rpt, "Ntry");
		final String addtlRptInf = DOMUtil.getElementValueByName(rpt, "AddtlRptInf");

		report.setIdentification(id);
		report.setCreationDateTime(DOMUtil.getDateTime(creDtTm));
		report.setAccount(this.acctParser.parse(acct));
		report.setBalance(this.balParser.parse(bal));

		final List<Entry> entries = new ArrayList<Entry>();
		for (final Element ntry : ntryList) {
			entries.add(this.ntryParser.parse(ntry));
		}

		report.setEntries(entries);
		report.setAdditionalReportInformation(addtlRptInf);

		return report;
	}
}
