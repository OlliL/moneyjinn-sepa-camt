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

import org.laladev.moneyjinn.sepa.camt.model.BankToCustomerAccountReport;
import org.laladev.moneyjinn.sepa.camt.util.DOMUtil;
import org.w3c.dom.Element;

public class BkToCstmrAcctRptParser {
	private final GrpHdrParser grpHdrParser = new GrpHdrParser();
	private final RptParser rptParser = new RptParser();

	public BankToCustomerAccountReport parse(final Element bkToCstmrAcctRpt) {
		final BankToCustomerAccountReport bankToCustomerAccountReport = new BankToCustomerAccountReport();

		final Element grpHdr = DOMUtil.getElementByName(bkToCstmrAcctRpt, "GrpHdr");
		final Element rpt = DOMUtil.getElementByName(bkToCstmrAcctRpt, "Rpt");

		bankToCustomerAccountReport.setGroupHeader(this.grpHdrParser.parse(grpHdr));
		bankToCustomerAccountReport.setReport(this.rptParser.parse(rpt));

		return bankToCustomerAccountReport;
	}
}
