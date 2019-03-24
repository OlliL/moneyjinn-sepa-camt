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

package org.laladev.moneyjinn.sepa.camt.mapper;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.laladev.moneyjinn.sepa.camt.model.BankToCustomerAccountReport;
import org.laladev.moneyjinn.sepa.camt.parser.BkToCstmrAcctRptParser;
import org.laladev.moneyjinn.sepa.camt.util.DOMUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

public class BankToCustomerAccountReportMapper {

	private final BkToCstmrAcctRptParser bkToCstmrAcctRptParser = new BkToCstmrAcctRptParser();

	public BankToCustomerAccountReport mapXml(final InputSource xml) throws Exception {
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
		factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);

		final DocumentBuilder builder = factory.newDocumentBuilder();
		final Document document = builder.parse(xml);
		final Element documentElement = document.getDocumentElement();
		if (documentElement.getAttribute("xmlns").equals("urn:iso:std:iso:20022:tech:xsd:camt.052.001.03")
				|| documentElement.getAttribute("xmlns").equals("urn:iso:std:iso:20022:tech:xsd:camt.052.001.06")) {
			final Element bkToCstmrAcctRpt = DOMUtil.getElementByName(documentElement, "BkToCstmrAcctRpt");
			if (bkToCstmrAcctRpt != null) {
				final BankToCustomerAccountReport bankToCustomerAccountReport = this.bkToCstmrAcctRptParser
						.parse(bkToCstmrAcctRpt);
				return bankToCustomerAccountReport;
			}
		}
		return null;
	}
}
