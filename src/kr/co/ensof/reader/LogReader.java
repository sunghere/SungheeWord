package kr.co.ensof.reader;


import java.io.*;
import java.util.*;

/**
 * Created by SungHere on 2017-10-27.
 */
public class LogReader {

    private static String CHAR_ENCODING = "EUC-KR";
    private HashMap<String, Integer> result = new HashMap<>();

    private String fileSize;
    private long wordCount; //총 단어의 갯수
    private int lineNum; // 라인수
    private ArrayList<HashMap.Entry<String, Integer>> ranking;

    public void fileRead(String path) throws IOException {
        File file = new File(path);

        fileSize = file.length() + "";

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), CHAR_ENCODING),1024);

        String temp = "";
        while ((temp = br.readLine()) != null) {
            lineNum++;
            temp.replaceAll("\\t", " "); //탭을 띄어쓰기로
            temp.replaceAll("\\n", " "); //줄바꿈을 띄어쓰기로
            String[] wordlists = temp.split("\\s+");

            wordCount += wordlists.length; //단어 갯수 더해줌

            for (String word : wordlists) {
                if (word.equals("")) { // 공백이면넘어가면서 단어갯수를 빼야함.
                    wordCount--;
                    continue;
                }

                if (result.containsKey(word)) { //포함하면 카운트 + 1
                    int count = result.get(word);
                    result.put(word, result.get(word) + 1);

                } else { //없으면 새로 등록
                    result.put(word, 1);

                }

            }

        }

        rankSort();
    }

    public void rankSort() {

        if (result == null) return; //오작동 방지
        ranking = new ArrayList<>();

        for (HashMap.Entry<String, Integer> resultEntry : result.entrySet()) {

            ranking.add(resultEntry);
        }

        Collections.sort(ranking, new Comparator<HashMap.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue()); //역순 정렬
            }
        });

    }

    public Vector<String> infoMessage() {

        Vector<String> messages = new Vector<>();


        messages.add("File Length : " + fileSize + " byte");
        messages.add("Line Count : " + lineNum);
        messages.add("Word Count : " + wordCount);
        StringBuilder sb = new StringBuilder("Rank -----------\n");
        for (int i = 0; i < 10 && i < ranking.size(); i++) { //단어 갯수가 10개가 안넘을경우 방지
            HashMap.Entry<String, Integer> temp = ranking.get(i);
            sb.append(i + ") \"" + temp.getKey() + "\" :" + temp.getValue() + "\n");

        }
        sb.append("-------RANK END");
        messages.add(sb.toString());


        return messages;

    }


}
