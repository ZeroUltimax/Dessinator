package Model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class ShapeList {

    private List<Shape> shapes;

    public ShapeList() {
        this.shapes = new ArrayList<>();
    }

    public ShapeList(Collection<Shape> shapes) {
        this.shapes = new ArrayList<>(shapes);
    }

    public Stream<Shape> stream() {
        return shapes.stream();
    }
    
    public ShapeList getSelected() {
        return new ShapeList(shapes.stream()
                .filter(s -> s.isSelected())
                .collect(Collectors.toList()));
    }

    public void setSelected(boolean selected) {
        for (Shape s : shapes) {
            s.setSelected(selected);
        }
    }

    public Shape getLast() {
        return shapes.get(shapes.size() - 1);
    }

    public void addLast(Shape addMe) {
        shapes.add(addMe);
    }

    public void drawTo(Graphics graphic) {
        for (Shape s : shapes) {
            s.drawTo(graphic);
        }
    }


}
