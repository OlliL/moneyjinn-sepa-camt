# moneyjinn-sepa-camt

camt.052.001.03 and camt.052.001.06 Parser.

## Usage
```
final StringReader characterStream = new StringReader(fileContents);
final InputSource xml = new InputSource(characterStream);

final BankToCustomerAccountReportMapper xmlMapper = new BankToCustomerAccountReportMapper();
final BankToCustomerAccountReport bankToCustomerAccountReport = xmlMapper.mapXml(xml);
```