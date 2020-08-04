package Instance;

public class TransferMoney {
    public static void main(String[] args) {
        printWords("6900390079.09");
    }

    static public void printWords(String money) {
        StringBuilder stringBuilder = new StringBuilder(money);
        StringBuilder printString = new StringBuilder();
        stringBuilder.reverse();
        char[] moneys = new char[money.length()];
        int pointNum = 0;
        int index = 0;
        stringBuilder.getChars(0, money.length(), moneys, 0);//将string转换成char数组
        if (moneys[1] == '.') {
            pointNum = 1;
        }
        if (moneys[2] == '.') {
            pointNum = 2;
        }
        for (int i = moneys.length - 1; i >= 0; i--) {
            if (pointNum == 0) {
                index = i;
            }
            if (pointNum == 1) {
                index = i - 2;
            }
            if (pointNum == 2) {
                index = i - 3;
            }
            switch (moneys[i]) {
                case '9': {
                    cases(printString, index, "九千", "九百", "九十", "九亿", "九万", "九元", "九角", "九分");
                    continue;
                }
                case '8': {
                    cases(printString, index, "八千", "八百", "八十", "八亿", "八万", "八元", "八角", "八分");
                    continue;
                }
                case '7': {
                    cases(printString, index, "七千", "七百", "七十", "七亿", "七万", "七元", "七角", "七分");
                    continue;
                }
                case '6': {
                    cases(printString, index, "六千", "六百", "六十", "六亿", "六万", "六元", "六角", "六分");
                    continue;
                }
                case '5': {
                    cases(printString, index, "五千", "五百", "五十", "五亿", "五万", "五元", "五角", "五分");
                    continue;
                }
                case '4': {
                    cases(printString, index, "四千", "四百", "四十", "四亿", "四万", "四元", "四角", "四分");
                    continue;
                }
                case '3': {
                    cases(printString, index, "三千", "三百", "三十", "三亿", "三万", "三元", "三角", "三分");
                    continue;
                }
                case '2': {
                    cases(printString, index, "二千", "二百", "二十", "二亿", "二万", "二元", "二角", "二分");
                    continue;
                }
                case '1': {
                    cases(printString, index, "一千", "一百", "一十", "一亿", "一万", "一元", "一角", "一分");
                    continue;
                }
                case '0': {
                    switch (index) {
                        case 11: {
                            printString.append("输入错误！");
                            break;
                        }
                        case 10:
                        case 9:
                        case 7:
                        case 6:
                        case 5:
                        case 3:
                        case 2:
                        case 1:
                        case -2: {
                            printString.append("零");
                            continue;
                        }
                        case 8: {
                            printString.append("亿");
                            continue;
                        }
                        case 4: {
                            printString.append("万");
                            continue;
                        }
                        case 0: {
                            printString.append("元");
                            continue;
                        }
                        case -1: {
                            continue;
                        }
                        case -3: {
                            printString.append("分");
                            continue;
                        }
                    }
                }

            }
        }
        //去除多个连续零
        removeExtraZeros(printString);
        System.out.println(printString.toString());
        ;
    }

    private static void cases(StringBuilder printString, int index, String 千, String 百, String 十, String 亿, String 万, String 元, String 角, String 分) {
        switch (index) {
            case 11:
            case 7:
            case 3: {
                printString.append(千);
                break;
            }
            case 10:
            case 6:
            case 2: {
                printString.append(百);
                break;
            }
            case 9:
            case 5:
            case 1: {
                printString.append(十);
                break;
            }
            case 8: {
                printString.append(亿);
                break;
            }
            case 4: {
                printString.append(万);
                break;
            }
            case 0: {
                printString.append(元);
                break;
            }
            case -1: {
                break;
            }
            case -2: {
                printString.append(角);
                break;
            }
            case -3: {
                printString.append(分);
                break;
            }
        }
    }

    private static void removeExtraZeros(StringBuilder printString) {
        int p = 0;
        while (p < printString.length()) {
            if (printString.charAt(p) == '零') {
                if (printString.charAt(p + 1) == '零') {
                    printString.setCharAt(p, '\0');
                }
            }
            p++;
        }
    }
}
