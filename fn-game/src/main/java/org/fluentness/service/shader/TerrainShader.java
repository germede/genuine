package org.fluentness.service.shader;

public class TerrainShader extends AbstractShader {

    public final int blendMap = getUniformLocation("blendMap");
    public final int blackTexture = getUniformLocation("blackTexture");
    public final int redTexture = getUniformLocation("redTexture");
    public final int greenTexture = getUniformLocation("greenTexture");
    public final int blueTexture = getUniformLocation("blueTexture");
    public final int repeatTextures = getUniformLocation("repeatTextures");

    @Override
    protected String getVertexShaderPath() {
        return "terrainVertexShader.txt";
    }

    @Override
    protected String getFragmentShaderPath() {
        return "terrainFragmentShader.txt";
    }

}
