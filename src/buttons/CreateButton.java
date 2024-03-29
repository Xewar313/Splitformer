package buttons;

import playground.Map;
import windows.WindowController;

import java.awt.*;

public class CreateButton extends Button {
    private final Rectangle body;
    private final WindowController target;

    public CreateButton(int x, int y, int sideLength, WindowController target) {
        body = new Rectangle(x, y, sideLength, sideLength);
        this.setBounds(body);
        this.target = target;
    }

    @Override
    public void draw(Graphics2D g) {

        g.setColor(Color.gray);
        g.fill(body);
        g.setColor(Color.white);
        g.fillRect(body.x + body.width/2 - body.width/10, body.y + 4, body.width/5, body.height - 8);
        g.fillRect(body.x + 4, body.y + body.height/2 - body.height/10, body.width - 8 , body.height/5);
    }

    @Override
    public boolean tryPress(int x, int y) {
        if (body.contains(x,y)) {
            Map temp;
            try {
                temp = new Map("basicVertical");
            } catch(Exception e) {
                return true;
            }

            target.startEditing(temp);
            return true;
        }
        return false;
    }
}
