String longestSubstring(String str) {
	    	int[] failure = new int[str.length()];
	    	failure[0] = -1;
	    	int i  = 1;	
	    	//compute failure function
	    	while (i < str.length()) {
	    		int cur = failure[i - 1];
	    		while (str.charAt(i) != str.charAt(cur + 1)) {
	    			if (cur != -1)
	    				cur = failure[cur];
	    			else
	    				break;
	    		}
	    		if (str.charAt(i) == str.charAt(cur + 1)) {
	    			failure[i] = cur + 1;
	    		}
	    		else
	    			failure[i] = -1;
	    		i++;
	    	}
	    	String res = null;
	    	for (i = 1; i < str.length() - 1; i++) {
	    		if (failure[i] == -1) {
	    			if (str.charAt(0) < str.charAt(i)) {
	    				res = str.substring(i);
	    				break; 
	    			}	    			
	    		}
	    		else {
	    			if (str.charAt(failure[i] + 1) < str.charAt(i + 1)) {
	    				res = str.substring(i - failure[i]);
	    				break;
	    			}
	    		}
	    	}
	    	if (str.charAt(0) < str.charAt(i))
	    		return str.substring(i);
	    	return res;
	    }
