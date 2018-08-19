package com.chroniker.gui;

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class BackgroundImage extends StackPane {

    private ImageView imageView;
    private Rectangle overlay;

    private ReadOnlyDoubleProperty x;
    private ReadOnlyDoubleProperty y;

    private double zoomFactor = 1;

    public BackgroundImage(String url, Stage stage, Paint overlayColor, double opacity) {
        super();

        imageView = new ImageView(url);
        imageView.imageProperty().addListener(observable -> redraw());
        imageView.setPreserveRatio(true);
        imageView.setCache(true);

        overlay = new Rectangle();
        overlay.widthProperty().bind(stage.widthProperty());
        overlay.heightProperty().bind(stage.heightProperty());
        overlay.setFill(overlayColor);
        overlay.setOpacity(opacity / 100f);

        setStage(stage);

        getChildren().addAll(imageView, overlay);

        redraw();
    }

    public BackgroundImage(String url, Stage stage) {
        this(url, stage, Color.BLACK, 25);
    }

    public void setStage(Stage stage) {
        setXProperty(stage.widthProperty());
        setYProperty(stage.heightProperty());
    }

    private void setXProperty(ReadOnlyDoubleProperty x) {
        this.x = x;
        this.x.addListener(observable -> redraw());
    }

    private void setYProperty(ReadOnlyDoubleProperty y) {
        this.y = y;
        this.y.addListener(observable -> redraw());
    }

    public void zoom(double zoomFactor) {
        this.zoomFactor = (zoomFactor != 0) ? zoomFactor : 1;
        redraw();
    }

    public void setOverlayOpacity(double opacity) {
        this.overlay.setOpacity(opacity / 100f);
    }

    public double getOverlayOpacity() {
        return this.overlay.getOpacity() * 100f;
    }

    private void redraw() {

        double ratio = imageView.getImage().getWidth() / imageView.getImage().getHeight();

        if(x.doubleValue() > (y.doubleValue() * ratio)) {
            imageView.fitWidthProperty().set(x.doubleValue() * zoomFactor);
        }else {
            imageView.fitWidthProperty().set(y.doubleValue() * ratio * zoomFactor);
        }

    }

}
