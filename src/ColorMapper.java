import javax.swing.*;
import java.awt.*;
import java.io.StringReader;
import java.util.Map;
import java.util.HashMap;

public class ColorMapper {
    public static void main(String[] args) throws Exception {
        String txt = "123 ABC abc";
        Map<Integer, Color> colorMap = new HashMap<Integer, Color>();
        colorMap.put(ColorizerConstants.DIGITS, Color.BLUE);
        colorMap.put(ColorizerConstants.LOWER, Color.RED);
        colorMap.put(ColorizerConstants.UPPER, Color.GREEN);
        new ColorizerTokenManager(new SimpleCharStream(new StringReader(txt)));

        JTextPane jtp = new JTextPane();
        jtp.setText(txt);

        JFrame jf = new JFrame();
        jf.add(jtp);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(100,200);
        jf.setVisible(true);

        Token t;
        while ((t = ColorizerTokenManager.getNextToken()).kind != 0) {
            jtp.setSelectionStart(t.beginColumn-1);
            jtp.setSelectionEnd(t.endColumn);
            jtp.setSelectionColor(colorMap.get(t.kind));
            Thread.currentThread().sleep(1000);
        }
    }
}
