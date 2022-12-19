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

package org.laladev.moneyjinn.sepa.camt.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import jakarta.xml.bind.DatatypeConverter;

public class DOMUtil {
	public static Element getElementByName(final Element element, final String name) {
		if (element != null) {
			// final NodeList nodeList = element.getChildNodes();
			// final int length = nodeList.getLength();
			// for (int i = 0; i < length; i++) {
			// final Node node = nodeList.item(i);
			// if (node.getNodeType() == Node.ELEMENT_NODE &&
			// node.getNodeName().equals(name)) {
			// return (Element) node;
			// }
			// }
			final NodeList nodeList = element.getElementsByTagName(name);
			final int length = nodeList.getLength();
			for (int i = 0; i < length; i++) {
				final Node node = nodeList.item(i);
				if (node.getParentNode().getNodeName().equals(element.getNodeName())) {
					return (Element) node;
				}
			}
		}

		return null;
	}

	public static List<Element> getElementsByName(final Element element, final String name) {
		final List<Element> elements = new ArrayList<>();
		// if (element != null) {
		// final NodeList nodeList = element.getChildNodes();
		// final int length = nodeList.getLength();
		// for (int i = 0; i < length; i++) {
		// final Node node = nodeList.item(i);
		// if (node.getNodeType() == Node.ELEMENT_NODE &&
		// node.getNodeName().equals(name)) {
		// elements.add((Element) node);
		// }
		// }
		// }
		final NodeList nodeList = element.getElementsByTagName(name);
		final int length = nodeList.getLength();
		for (int i = 0; i < length; i++) {
			final Node node = nodeList.item(i);
			if (node.getParentNode().getNodeName().equals(element.getNodeName())) {
				elements.add((Element) node);
			}
		}
		return elements;
	}

	public static String getElementValueByName(final Element element, final String name) {
		final Element childElement = getElementByName(element, name);
		if (childElement != null) {
			return childElement.getTextContent();
		}
		return "";
	}

	public static List<String> getElementValuesByName(final Element element, final String name) {
		final List<Element> childElements = getElementsByName(element, name);
		final List<String> values = new ArrayList<>();
		if (!childElements.isEmpty()) {
			for (final Element childElement : childElements) {
				values.add(childElement.getTextContent());
			}
		}
		return values;
	}

	public static Calendar getDateTime(final Element element) {
		if (element == null) {
			return null;
		}
		final Calendar parseDateTime = DatatypeConverter.parseDateTime(element.getTextContent());
		// to force call of Calendar.complete()
		parseDateTime.get(Calendar.ERA);
		return parseDateTime;

	}
}
