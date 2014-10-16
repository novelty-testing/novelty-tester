(function () { "use strict";
var fr = {}
fr.inria = {}
fr.inria.diverse = {}
fr.inria.diverse.noveltytesting = {}
fr.inria.diverse.noveltytesting.samples = {}
fr.inria.diverse.noveltytesting.samples.Functions = function() { }
fr.inria.diverse.noveltytesting.samples.FunctionsImpl = function() {
};
fr.inria.diverse.noveltytesting.samples.FunctionsImpl.__interfaces__ = [fr.inria.diverse.noveltytesting.samples.Functions];
fr.inria.diverse.noveltytesting.samples.FunctionsImpl.prototype = {
	fibIter: function(limit) {
		var current;
		var nextItem;
		var lim;
		current = 0;
		nextItem = 1;
		lim = limit;
		var hasNext = function() {
			return limit > 0;
		};
		var next = function() {
			limit--;
			var ret = current;
			var temp = current + nextItem;
			current = nextItem;
			nextItem = temp;
			return ret;
		};
		return lim;
	}
	,lookAndSay: function(s) {
		if(s == null || s == "") return "";
		var results = "";
		var repeat = s.charAt(0);
		var amount = 1;
		var _g1 = 1, _g = s.length;
		while(_g1 < _g) {
			var i = _g1++;
			var actual = s.charAt(i);
			if(actual != repeat) {
				results += amount;
				results += repeat;
				repeat = actual;
				amount = 0;
			}
			amount++;
		}
		results += amount;
		results += repeat;
		return results;
	}
	,compare: function(a,b) {
		var a1 = a.toLowerCase();
		var b1 = b.toLowerCase();
		if(a1 < b1) return -1;
		if(a1 > b1) return 1;
		return 0;
	}
}
fr.inria.diverse.noveltytesting.samples.Main = function() { }
fr.inria.diverse.noveltytesting.samples.Main.main = function() {
	var fun = new fr.inria.diverse.noveltytesting.samples.FunctionsImpl();
	var test = "1";
	var _g = 0;
	while(_g < 11) {
		var i = _g++;
		test = fun.lookAndSay(test);
		console.log(test);
	}
	var x = fun.fibIter(10);
	console.log(x);
	var j = fun.compare("bla","blabla");
	console.log(j);
}
fr.inria.diverse.noveltytesting.samples.Main.main();
})();
