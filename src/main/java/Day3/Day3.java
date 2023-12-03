package Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Day3 {

    double totalSum;

    public Day3() throws IOException {
        this.totalSum = 0;
        Path path = Paths.get("src/main/java/Day3/Day3.txt");

        String allLines = Files.readString(path);
        char[] dataSet = allLines.toCharArray();

        for (int i = 0; i < dataSet.length; i++) {
            if (dataSet[i] == '.' || isSymbol(dataSet[i])) {
                continue;
            }

            StringBuilder tempStringOfValue = new StringBuilder();
            if (Character.isDigit(dataSet[i])) {
                if (isSymbol(dataSet[i - 1]) || isSymbol(dataSet[i + 1])) {

                    if (i >= 141 && !isSymbol(dataSet[i - 140]) || i >= 141 && !isSymbol(dataSet[i - 141]) || i >= 141 && !isSymbol(dataSet[i - 139])) {
                        if (dataSet[i-1] != '.' && !isSymbol(dataSet[i-1])) {
                            if (dataSet[i - 2] != '.' && !isSymbol(dataSet[i - 2])) {
                                tempStringOfValue.append(dataSet[i - 2]);
                            }
                            if (dataSet[i - 1] != '.' && !isSymbol(dataSet[i - 1])) {
                                tempStringOfValue.append(dataSet[i - 1]);
                            }
                        }
                        if (dataSet[i] != '.' && !isSymbol(dataSet[i])) {
                            tempStringOfValue.append(dataSet[i]);

                        }
                        if (dataSet[i + 1] != '.' && !isSymbol(dataSet[i + 1])) {
                            tempStringOfValue.append(dataSet[i + 1]);

                        }
                        if (dataSet[i+1] != '.' && !isSymbol(dataSet[i+1])) {
                            if (dataSet[i + 2] != '.' && !isSymbol(dataSet[i + 2])) {
                                tempStringOfValue.append(dataSet[i + 2]);
                            }
                        }
                        String stringToBeParsed = tempStringOfValue.toString().replace(".", "");
                        System.out.println(stringToBeParsed);
                        totalSum += Double.parseDouble(stringToBeParsed);
                        if (Character.isDigit(dataSet[i+1])) {
                            i++;
                            if (Character.isDigit(dataSet[i+1])) {
                                i++;
                            }
                        }

                        continue;
                    }
                }
                if (i < (dataSet.length - 141)) {
                    if (isSymbol(dataSet[i + 140]) || isSymbol(dataSet[i + 141]) || isSymbol(dataSet[i + 142])) {
                        if (dataSet[i-1] != '.' && !isSymbol(dataSet[i-1])) {
                            if (dataSet[i - 2] != '.' && !isSymbol(dataSet[i - 2])) {
                                tempStringOfValue.append(dataSet[i - 2]);
                            }
                            if (dataSet[i - 1] != '.' && !isSymbol(dataSet[i - 1])) {
                                tempStringOfValue.append(dataSet[i - 1]);
                            }
                        }
                        if (dataSet[i] != '.' && !isSymbol(dataSet[i])) {
                            tempStringOfValue.append(dataSet[i]);

                        }
                        if (dataSet[i + 1] != '.' && !isSymbol(dataSet[i + 1])) {
                            tempStringOfValue.append(dataSet[i + 1]);

                        }
                        if (dataSet[i+1] != '.' && !isSymbol(dataSet[i+1])) {
                            if (dataSet[i + 2] != '.' && !isSymbol(dataSet[i + 2])) {
                                tempStringOfValue.append(dataSet[i + 2]);
                            }
                        }
                        String stringToBeParsed = tempStringOfValue.toString().replace(".", "");
                        System.out.println(stringToBeParsed);
                        totalSum += Double.parseDouble(stringToBeParsed);
                        if (Character.isDigit(dataSet[i+1])) {
                            i++;
                            if (Character.isDigit(dataSet[i+1])) {
                                i++;
                            }
                        }
                        continue;
                    }
                }

                if (i > 139) {
                    if (isSymbol(dataSet[i - 140]) || isSymbol(dataSet[i -141]) || isSymbol(dataSet[i-142])) {
                        if (dataSet[i-1] != '.' && !isSymbol(dataSet[i-1])) {
                            if (dataSet[i - 2] != '.' && !isSymbol(dataSet[i - 2])) {
                                tempStringOfValue.append(dataSet[i - 2]);
                            }
                            if (dataSet[i - 1] != '.' && !isSymbol(dataSet[i - 1])) {
                                tempStringOfValue.append(dataSet[i - 1]);
                            }
                        }
                        if (dataSet[i] != '.' && !isSymbol(dataSet[i])) {
                            tempStringOfValue.append(dataSet[i]);

                        }
                        if (dataSet[i + 1] != '.' && !isSymbol(dataSet[i + 1])) {
                            tempStringOfValue.append(dataSet[i + 1]);

                        }
                        if (dataSet[i+1] != '.' && !isSymbol(dataSet[i+1])) {
                            if (dataSet[i + 2] != '.' && !isSymbol(dataSet[i + 2])) {
                                tempStringOfValue.append(dataSet[i + 2]);
                            }
                        }
                        String stringToBeParsed = tempStringOfValue.toString().replace(".", "");
                        System.out.println(stringToBeParsed);
                        totalSum += Double.parseDouble(stringToBeParsed);

                        if (Character.isDigit(dataSet[i+1])) {
                            i++;
                            if (Character.isDigit(dataSet[i+1])) {
                                i++;
                            }
                        }
                    }
                }

            }

        }
        System.out.println(totalSum);
        System.out.println(dataSet.length / 140);
    }




    public boolean isSymbol(char input) {
        return input == '*' ||
                input == '/' ||
                input == '#' ||
                input == '&' ||
                input == '@' ||
                input == '$' ||
                input == '+' ||
                input == '-' ||
                input == '=' ||
                input == '%';
    }

    public static void main(String[] args) {
        try {
            new Day3();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
