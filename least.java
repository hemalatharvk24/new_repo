class DecreasingResult {
    public int firstDecreasing;
    public int nextStart;
}

public static String getLeastNumberDeletingDigits_2(String number, int k) {
    String leastNumber = number;
    int start = 0;
    while(k > 0 && leastNumber.length() > 0) {
        DecreasingResult result = getNextDecreasing(leastNumber, start);
        if(result.firstDecreasing >= 0) {
            leastNumber = removeDigit(leastNumber, result.firstDecreasing);
        }
        else {
            leastNumber = removeDigit(leastNumber, leastNumber.length() - 1);
        }

        start = result.nextStart;
        --k;
    }

    return leastNumber;
}

private static DecreasingResult getNextDecreasing(String number, int start) {
    int firstDecreasing = -1;
    int nextStart;

    for(int i = start; i < number.length() - 1; ++i) {
        int curDigit = number.charAt(i) - '0';
        int nextDigit = number.charAt(i + 1) - '0';
        if(curDigit > nextDigit) {
            firstDecreasing = i;
            break;
        }
    }

    if(firstDecreasing == 0) {
        nextStart = 0;
    }
    else if (firstDecreasing > 0) {
        nextStart = firstDecreasing - 1;
    }
    else {
        nextStart = number.length();
    }

    DecreasingResult result = new DecreasingResult();
    result.firstDecreasing = firstDecreasing;
    result.nextStart = nextStart;

    return result;
}
