// Copyright Hugh Perkins 2013
// You can use this under the Mozilla Public License 2.0

import org.apache.tools.ant.*;
import java.util.*;
import java.io.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.image.*;

public class BigText extends Task {
    private static final Color OPAQUE_WHITE = new Color(0xFFFFFFFF, true);
    private static final Color TRANSPARENT_BLACK = new Color(0x00000000, true);


    String message;
    int size = 20;
    String fontname = "Times New Roman";
    public void setMessage( String message ) {
        this.message = message;
    }
    public void setSize( int size ) {
        this.size = size;
    }
    public void setFontname( String fontname ) {
        this.fontname = fontname;
    }
    public void execute() throws BuildException {
BufferedImage image = new BufferedImage(1024, 1024, BufferedImage.TYPE_INT_RGB);
Graphics g = image.getGraphics();
g.setFont(new Font(fontname , Font.ITALIC, size));
FontMetrics fm = g.getFontMetrics();

int width = fm.stringWidth(message);

int height = fm.getHeight();

image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
g = image.getGraphics();
g.setFont(new Font(fontname, Font.ITALIC, size));
Graphics2D graphics = (Graphics2D) g;
graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
graphics.setColor(OPAQUE_WHITE);

graphics.setBackground(TRANSPARENT_BLACK);

graphics.drawString(message, 0, height);

for (int y = 0; y < height; y++) {
    StringBuilder sb = new StringBuilder();
    for (int x = 0; x < width; x++)
        sb.append(image.getRGB(x, y) == -16777216 ? " " : image.getRGB(x, y) == -1 ? "#" : "*");
    if (sb.toString().trim().isEmpty()) continue;
    System.out.println(sb);
}

    }
}

