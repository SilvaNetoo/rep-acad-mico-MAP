package com.map.wrappers.proxy;

import java.io.IOException;

/**
 * Adaptador de imagens gif. Usa a biblioteca <code>ImprovedGif</code> para
 * desenhar imagens Gif e o cabeçalho para responder informações sobre
 * a altura e a largura.
 */
class AdapterGif implements Imagem {
    Cabecalho cabecalho;
    ImprovedGif ig;
    Path path;

    AdapterGif(ImprovedGif ig, Path path, Cabecalho cabecalho) {
        this.ig = ig;
        this.cabecalho = cabecalho;
        this.path = path;
    }

    @Override
    public short altura() {
        return this.cabecalho.altura();
    }

    @Override
    public short largura() {
        return this.cabecalho.largura();
    }

    public String getTipo() {
        return this.path.getTipo();
    }

    @Override
    public void draw() throws IOException {
        try {
            this.ig.draw();
        } catch (ImprovedGif.TenteiENaoConseguiAbrirException e) {
            throw new IOException(e);
        }
    }

    @Override
    public byte[][] content() throws IOException {
        return new byte[][]{
                new byte[]{0, 1}
        };
    }

    @Override
    public String toString() {
        return "Path: " + this.path.get() + " Tipo:" + getTipo() + " largura:" + largura() + " altura:" + altura();
    }
}