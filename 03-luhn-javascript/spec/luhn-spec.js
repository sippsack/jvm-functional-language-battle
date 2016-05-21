/**
 * Created by fsippach on 26.04.2016.
 */

var luhn = require('../app/luhn.js')

var runs = [
    {ccName: 'American Expres', ccNumber: '378282246310005'},
    {ccName: 'American Express', ccNumber: '371449635398431'},
    {ccName: 'American Express Corporate', ccNumber: '378734493671000'},
    {ccName: 'Australian BankCard', ccNumber: '5610591081018250'},
    {ccName: 'Diners Club', ccNumber: '30569309025904'},
    {ccName: 'Diners Club', ccNumber: '38520000023237'},
    {ccName: 'Discover', ccNumber: '6011111111111117'},
    {ccName: 'Discover', ccNumber: '6011000990139424'},
    {ccName: 'JCB', ccNumber: '3530111333300000'},
    {ccName: 'JCB', ccNumber: '3566002020360505'},
    {ccName: 'MasterCard', ccNumber: '5555555555554444'},
    {ccName: 'MasterCard', ccNumber: '5105105105105100'},
    {ccName: 'Visa', ccNumber: '4111111111111111'},
    {ccName: 'Visa', ccNumber: '4012888888881881'},
    {ccName: 'Visa', ccNumber: '4222222222222'},
    {ccName: 'Dankort (PBS)', ccNumber: '76009244561', expected: false},
    {ccName: 'Dankort (PBS)', ccNumber: '5019717010103742'},
    {ccName: 'Switch/Solo (Paymentech)', ccNumber: '6331101999990016'},
    {ccName: 'Switch/Solo (Paymentech)', ccNumber: '6331 1019 9999 0016'},
    {ccName: 'Switch/Solo (Paymentech)', ccNumber: '6331-1019-9999-0016'},
    {ccName: 'contains only characters', ccNumber: 'abc', expected: false},
    {ccName: 'contains character', ccNumber: 'A6331101999990016', expected: false}
];

describe('checkCreditCardNumber', function () {
    it('credit card number must be valid', function () {
        runs.forEach(function (run) {
            var result = luhn.validate.apply(luhn, [run.ccNumber]);
            expect(result).toEqual((typeof run.expected != 'undefined' ? run.expected : true), run.ccName + ' with #' + run.ccNumber + ' is not valid!');
        });
    });
});

