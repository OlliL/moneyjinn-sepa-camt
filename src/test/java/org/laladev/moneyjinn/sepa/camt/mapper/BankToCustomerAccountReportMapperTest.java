package org.laladev.moneyjinn.sepa.camt.mapper;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.junit.Assert;
import org.junit.Test;
import org.laladev.moneyjinn.sepa.camt.model.Account;
import org.laladev.moneyjinn.sepa.camt.model.Balance;
import org.laladev.moneyjinn.sepa.camt.model.BalanceType12Code;
import org.laladev.moneyjinn.sepa.camt.model.BankToCustomerAccountReport;
import org.laladev.moneyjinn.sepa.camt.model.CreditDebitCode;
import org.laladev.moneyjinn.sepa.camt.model.Entry;
import org.laladev.moneyjinn.sepa.camt.model.EntryDetails;
import org.laladev.moneyjinn.sepa.camt.model.EntryStatus2Code;
import org.laladev.moneyjinn.sepa.camt.model.GroupHeader;
import org.laladev.moneyjinn.sepa.camt.model.Report;
import org.laladev.moneyjinn.sepa.camt.model.common.Amount;
import org.laladev.moneyjinn.sepa.camt.model.common.party.Creditor;
import org.laladev.moneyjinn.sepa.camt.model.common.party.Debtor;
import org.laladev.moneyjinn.sepa.camt.model.common.party.MessageRecipient;
import org.laladev.moneyjinn.sepa.camt.model.id.Iban;
import org.laladev.moneyjinn.sepa.camt.model.transactiondetails.BankTransactionCode;
import org.laladev.moneyjinn.sepa.camt.model.transactiondetails.RelatedParties;
import org.laladev.moneyjinn.sepa.camt.model.transactiondetails.RemittanceInformation;
import org.laladev.moneyjinn.sepa.camt.model.transactiondetails.TransactionDetails;
import org.xml.sax.InputSource;

public class BankToCustomerAccountReportMapperTest {

	BankToCustomerAccountReportMapper mapper = new BankToCustomerAccountReportMapper();

	@Test
	public void parseTestFile_resultIsAsExpected() throws Exception {
		final BankToCustomerAccountReport expected = new BankToCustomerAccountReport();

		final GroupHeader groupHeader = this.getGroupHeader();
		expected.setGroupHeader(groupHeader);

		final Report report = this.getReport();
		expected.setReport(report);

		final ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		final InputStream is = classloader.getResourceAsStream("test_1.xml");
		final InputSource xml = new InputSource(is);
		final BankToCustomerAccountReport actual = this.mapper.mapXml(xml);
		Assert.assertEquals(expected.getGroupHeader(), actual.getGroupHeader());

		Assert.assertEquals(expected.getReport().getAdditionalReportInformation(),
				actual.getReport().getAdditionalReportInformation());
		Assert.assertEquals(expected.getReport().getIdentification(), actual.getReport().getIdentification());
		Assert.assertEquals(expected.getReport().getAccount(), actual.getReport().getAccount());
		Assert.assertEquals(expected.getReport().getBalance(), actual.getReport().getBalance());
		Assert.assertEquals(expected.getReport().getCreationDateTime(), actual.getReport().getCreationDateTime());

		Assert.assertEquals(expected.getReport().getEntries().get(0).getAmount(),
				actual.getReport().getEntries().get(0).getAmount());
		Assert.assertEquals(expected.getReport().getEntries().get(0).getCreditDebitIndicator(),
				actual.getReport().getEntries().get(0).getCreditDebitIndicator());
		Assert.assertEquals(expected.getReport().getEntries().get(0).getEntryDetails(),
				actual.getReport().getEntries().get(0).getEntryDetails());
		Assert.assertEquals(expected.getReport().getEntries().get(0).getStatus(),
				actual.getReport().getEntries().get(0).getStatus());
		Assert.assertEquals(expected.getReport().getEntries().get(0).getBookingDate(),
				actual.getReport().getEntries().get(0).getBookingDate());
		Assert.assertEquals(expected.getReport().getEntries().get(0).getValueDate(),
				actual.getReport().getEntries().get(0).getValueDate());

		Assert.assertEquals(expected.getReport().getEntries().get(1).getAmount(),
				actual.getReport().getEntries().get(1).getAmount());
		Assert.assertEquals(expected.getReport().getEntries().get(1).getCreditDebitIndicator(),
				actual.getReport().getEntries().get(1).getCreditDebitIndicator());
		Assert.assertEquals(expected.getReport().getEntries().get(1).getEntryDetails(),
				actual.getReport().getEntries().get(1).getEntryDetails());
		Assert.assertEquals(expected.getReport().getEntries().get(1).getStatus(),
				actual.getReport().getEntries().get(1).getStatus());
		Assert.assertEquals(expected.getReport().getEntries().get(1).getBookingDate(),
				actual.getReport().getEntries().get(1).getBookingDate());
		Assert.assertEquals(expected.getReport().getEntries().get(1).getValueDate(),
				actual.getReport().getEntries().get(1).getValueDate());

		Assert.assertEquals(expected.getReport(), actual.getReport());
	}

	private GregorianCalendar getIdCalendar() {
		final GregorianCalendar creationDateTime = (GregorianCalendar) Calendar
				.getInstance(TimeZone.getTimeZone("GMT+1:00"));
		creationDateTime.clear();
		creationDateTime.set(2015, 9, 10, 7, 44, 33);
		creationDateTime.set(Calendar.MILLISECOND, 92);
		creationDateTime.setGregorianChange(new Date(-9223372036854775808L));
		return creationDateTime;
	}

	private GregorianCalendar getEntryCalendar() {
		final GregorianCalendar creationDateTime = (GregorianCalendar) Calendar.getInstance();
		creationDateTime.clear();
		creationDateTime.set(2015, 9, 10);
		creationDateTime.setGregorianChange(new Date(-9223372036854775808L));
		return creationDateTime;
	}

	private GroupHeader getGroupHeader() {
		final GroupHeader groupHeader = new GroupHeader();

		groupHeader.setCreationDateTime(this.getIdCalendar());
		groupHeader.setMessageIdentification("Whatever_KtoNr0000000000_10-10-2015_0744");
		groupHeader.setMessageRecipient(new MessageRecipient("Klaus King Miranda Queen"));

		return groupHeader;
	}

	private Report getReport() {
		final Report report = new Report();
		report.setIdentification("Whatever_KtoNr0000000000_10-10-2015_0744");
		report.setCreationDateTime(this.getIdCalendar());

		final Account account = new Account();
		account.setId(new Iban("XX00000000000000000000"));
		report.setAccount(account);

		final Balance balance = new Balance();
		balance.setType(BalanceType12Code.ClosingAvaliable);
		balance.setAmount(new Amount(new BigDecimal("1.00"), "EUR"));
		balance.setCreditDebitIndicator(CreditDebitCode.Credit);
		balance.setDate(this.getIdCalendar());
		report.setBalance(balance);

		report.setEntries(Arrays.asList(this.getEntry1(), this.getEntry2()));

		report.setAdditionalReportInformation("Summe vorgemerkter Umsätze: 0 EUR");
		return report;
	}

	private Entry getEntry1() {
		final Entry entry = new Entry();
		entry.setAmount(new Amount(new BigDecimal("10.00"), "EUR"));
		entry.setCreditDebitIndicator(CreditDebitCode.Debit);
		entry.setStatus(EntryStatus2Code.Booked);
		entry.setBookingDate(this.getEntryCalendar());
		entry.setValueDate(this.getEntryCalendar());

		final EntryDetails entryDetails = new EntryDetails();
		final TransactionDetails transactionDetails = new TransactionDetails();

		final BankTransactionCode bankTransactionCode = new BankTransactionCode();
		bankTransactionCode.setCode("NDDT+105");
		bankTransactionCode.setIssuer("ZKA");
		transactionDetails.setBankTransactionCode(bankTransactionCode);

		final RelatedParties relatedParties = new RelatedParties();
		relatedParties.setCreditor(new Creditor("ABCD"));
		relatedParties.setDebtor(new Debtor("Klaus King Miranda Queen"));
		transactionDetails.setRelatedParties(relatedParties);

		final RemittanceInformation remittanceInformation = new RemittanceInformation();
		remittanceInformation.setUnstructured(Arrays.asList("line 1.1", "line 1.2"));
		transactionDetails.setRemittanceInformation(remittanceInformation);

		entryDetails.setTransactionDetails(transactionDetails);
		entry.setEntryDetails(entryDetails);

		return entry;
	}

	private Entry getEntry2() {
		final Entry entry = new Entry();
		entry.setAmount(new Amount(new BigDecimal("2.00"), "EUR"));
		entry.setCreditDebitIndicator(CreditDebitCode.Credit);
		entry.setStatus(EntryStatus2Code.Booked);
		entry.setBookingDate(this.getEntryCalendar());
		entry.setValueDate(this.getEntryCalendar());

		final EntryDetails entryDetails = new EntryDetails();
		final TransactionDetails transactionDetails = new TransactionDetails();

		final BankTransactionCode bankTransactionCode = new BankTransactionCode();
		bankTransactionCode.setCode("NTRF+153");
		bankTransactionCode.setIssuer("ZKA");
		transactionDetails.setBankTransactionCode(bankTransactionCode);

		final RelatedParties relatedParties = new RelatedParties();
		relatedParties.setCreditor(new Creditor("Klaus King Miranda Queen"));
		relatedParties.setDebtor(new Debtor("EFGH"));
		transactionDetails.setRelatedParties(relatedParties);

		final RemittanceInformation remittanceInformation = new RemittanceInformation();
		remittanceInformation.setUnstructured(Arrays.asList("line 2.1", "line 2.2"));
		transactionDetails.setRemittanceInformation(remittanceInformation);

		entryDetails.setTransactionDetails(transactionDetails);
		entry.setEntryDetails(entryDetails);

		return entry;
	}
}
