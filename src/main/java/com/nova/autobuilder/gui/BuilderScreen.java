package com.nova.autobuilder.gui;

import com.nova.autobuilder.config.BuilderConfig;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class BuilderScreen extends Screen {

    public BuilderScreen() {
        super(Text.literal("NOVA AUTO BUILDER"));
    }

    @Override
    protected void init() {
        super.init();

        int centerX = this.width / 2;
        int centerY = this.height / 2;

        // Butang Start
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Start Build"), button -> {
            BuilderConfig.setRunning(true);
            BuilderConfig.setPaused(false);
        }).dimensions(centerX - 100, centerY - 50, 200, 20).build());

        // Butang Pause / Resume
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Pause / Resume"), button -> {
            if (BuilderConfig.isRunning()) {
                BuilderConfig.setPaused(!BuilderConfig.isPaused());
            }
        }).dimensions(centerX - 100, centerY - 25, 200, 20).build());

        // Butang Stop
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Stop Build"), button -> {
            BuilderConfig.setRunning(false);
            BuilderConfig.setPaused(false);
        }).dimensions(centerX - 100, centerY, 200, 20).build());

        // Butang Tutup GUI
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Close"), button -> {
            this.close();
        }).dimensions(centerX - 100, centerY + 35, 200, 20).build());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        // Latar belakang gelap bertema ungu (Hitam pekat dengan rona gelap)
        context.fillGradient(0, 0, this.width, this.height, 0xFF120A2A, 0xFF05020A);

        // Tajuk Utama Client
        context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 30, 0xD183FF);

        // Status Paparan
        String statusText = "Status: " + (!BuilderConfig.isRunning() ? "Idle" : (BuilderConfig.isPaused() ? "Paused" : "Running"));
        context.drawCenteredTextWithShadow(this.textRenderer, Text.literal(statusText), this.width / 2, 60, 0xFFFFFF);

        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPauseWhenBlurred() {
        return false;
    }
}
