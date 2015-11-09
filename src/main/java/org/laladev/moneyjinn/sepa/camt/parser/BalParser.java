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

import org.laladev.moneyjinn.sepa.camt.model.Balance;
import org.laladev.moneyjinn.sepa.camt.model.BalanceType12Code;
import org.laladev.moneyjinn.sepa.camt.model.CreditDebitCode;
import org.laladev.moneyjinn.sepa.camt.util.DOMUtil;
import org.w3c.dom.Element;

public class BalParser {
	private final AmtParser amtParser = new AmtParser();

	public Balance parse(final Element bal) {
		final Balance balance = new Balance();

		final Element tp = DOMUtil.getElementByName(bal, "Tp");
		final Element cdOrPrtry = DOMUtil.getElementByName(tp, "CdOrPrtry");
		final String cd = DOMUtil.getElementValueByName(cdOrPrtry, "Cd");
		final Element amt = DOMUtil.getElementByName(bal, "Amt");
		final String cdtDbtInd = DOMUtil.getElementValueByName(bal, "CdtDbtInd");
		final Element dt = DOMUtil.getElementByName(bal, "Dt");
		final Element dtTm = DOMUtil.getElementByName(dt, "DtTm");
		final Element dtDt = DOMUtil.getElementByName(dt, "Dt");

		balance.setType(BalanceType12Code.fromString(cd));
		balance.setAmount(this.amtParser.parse(amt));
		balance.setCreditDebitIndicator(CreditDebitCode.fromString(cdtDbtInd));
		if (dtTm != null) {
			balance.setDate(DOMUtil.getDateTime(dtTm));
		} else {
			balance.setDate(DOMUtil.getDateTime(dtDt));
		}

		return balance;
	}
}
