var app = app || {};

app.requester = (function() {
    function Requester(baseUrl) {
        this._baseUrl = baseUrl;
    }

    Requester.prototype.get = function (serviceUrl) {
        var headers = getHeaders();
        var url = this._baseUrl + serviceUrl;

        return makeRequest('GET', headers, url);
    };

    Requester.prototype.post= function(serviceUrl, data) {
        var headers = getHeaders();
        var url = this._baseUrl + serviceUrl;

        return makeRequest('POST', headers, url, data);
    }

    Requester.prototype.put = function (serviceUrl, data) {
        var headers = getHeaders();
        var url = this._baseUrl + serviceUrl;

        return makeRequest('PUT', headers, url, data);
    }

    Requester.prototype.delete = function (serviceUrl) {
        var headers = getHeaders();
        var url = this._baseUrl + serviceUrl;

        return makeRequest('DELETE', headers, url);
    }

    function makeRequest(method, headers, url, data) {
        var defer = Q.defer();

        $.ajax({
            method: method,
            headers: headers,
            url: url,
            data: JSON.stringify(data),
            success: function (data) {
                defer.resolve(data);
            },
            error: function (error) {
                defer.reject(error);
            }
        });

        return defer.promise;
    }

    function getHeaders() {
        var headers = {
            'X-Parse-Application-Id': 'U4IU61i37kI9Q8PvwVfVnklxDGVmRXuYzH10NjVJ',
            'X-Parse-REST-API-Key': '7xYggktCMEDMmkbUANTp0p4wUD9RlkanUPGDUy10',
            'Content-Type' : 'application/json'
        };

        if(localStorage['sessionToken']) {
            headers['X-Parse-Session-Token'] = localStorage['sessionToken'];
        }

        return headers;
    }

    return {
        load: function (baseUrl) {
            return new Requester(baseUrl);
        }
    }
}());