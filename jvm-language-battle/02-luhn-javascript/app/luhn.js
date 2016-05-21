module.exports = {
    validate2: function (imei) {
        return /^\d+$/.test(imei) && ((imei.split('').reduce(function (sum, d, n) {
                //console.log(sum + ' ' + d + ' ' + n + ' ' + (n===(imei.length-1)).toString() + ' ' + (n%2) + ' ' + ((n%2)? d: [0,2,4,6,8,1,3,5,7,9][d]));
                return n === (imei.length - 1)
                    ? 0
                    : sum + parseInt((n % 2) ? d : [0, 2, 4, 6, 8, 1, 3, 5, 7, 9][d]);
            }, 0)) % 10 == 0);
    },
    luhn1: function (imei) {
        console.log(imei.split('').map(function (d) {
            return parseInt(d)
        }))
        return imei.split('').map(function (d, idx) {
            return parseInt((idx % 2) ? d : [0, 2, 4, 6, 8, 1, 3, 5, 7, 9][d])
        });
    },
    validate: function (cardNo) {
        // cardNo as a string w/ digits only
        if (!/^\d+/.test(cardNo.replace(/[\s-]/g, ''))) {
            return false;
        }
        var sum = 0, even = false;
        cardNo.replace(/[\s-]/g, '').split('').reverse().forEach(function (dstr) {
            d = parseInt(dstr);
            sum += ((even = !even) ? d : (d < 5) ? d * 2 : (d - 5) * 2 + 1);
        });
        return (sum % 10 == 0);
    }
};
