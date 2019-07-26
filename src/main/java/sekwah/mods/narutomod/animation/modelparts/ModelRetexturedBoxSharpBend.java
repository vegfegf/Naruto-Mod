package sekwah.mods.narutomod.animation.modelparts;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.PositionTextureVertex;
import net.minecraft.client.model.TexturedQuad;
import net.minecraft.client.renderer.Tessellator;
import sekwah.mods.narutomod.animation.OffsetPositionTextureVertex;

public class ModelRetexturedBoxSharpBend extends ModelBox {
    /**
     * X vertex coordinate of lower box corner
     */
    public float posX1;
    /**
     * Y vertex coordinate of lower box corner
     */
    public float posY1;
    /**
     * Z vertex coordinate of lower box corner
     */
    public float posZ1;
    /**
     * X vertex coordinate of upper box corner
     */
    public float posX2;
    /**
     * Y vertex coordinate of upper box corner
     */
    public float posY2;
    /**
     * Z vertex coordinate of upper box corner
     */
    public float posZ2;
    public String field_78247_g;
    public float lowerRotation = 0; // rotation in radians because its what mc does it in
    public float upperRotation = 0;
    /**
     * The (x,y,z) vertex positions and (u,v) texture coordinates for each of the 8 points on a cube
     */
    private OffsetPositionTextureVertex[] vertexPositions;
    /**
     * An array of 6 TexturedQuads, one for each face of a cube
     */
    private TexturedQuad[] quadList;
    private float[] args;

    public ModelRetexturedBoxSharpBend(ModelRenderer par1ModelRenderer, int par2, int par3, float par4, float par5, float par6, int par7, int par8, int par9, float par10, int topX, int topY, int botX, int botY) {
        super(par1ModelRenderer, par2, par3, par4, par5, par6, par7, par8, par9, par10);
        args = new float[13];
        args[0] = par2;
        args[1] = par3;
        args[2] = par4;
        args[3] = par5;
        args[4] = par6;
        args[5] = par7;
        args[6] = par8;
        args[7] = par9;
        args[8] = par10;
        args[9] = topX;
        args[10] = topY;
        args[11] = botX;
        args[12] = botY;

        this.posX1 = par4;
        this.posY1 = par5;
        this.posZ1 = par6;
        this.posX2 = par4 + (float) par7;
        this.posY2 = par5 + (float) par8;
        this.posZ2 = par6 + (float) par9;
        this.vertexPositions = new OffsetPositionTextureVertex[8];
        this.quadList = new TexturedQuad[6];
        float f4 = par4 + (float) par7;
        float f5 = par5 + (float) par8;
        float f6 = par6 + (float) par9;
        par4 -= par10;
        par5 -= par10;
        par6 -= par10;
        f4 += par10;
        f5 += par10;
        f6 += par10;

        if (par1ModelRenderer.mirror) {
            float f7 = f4;
            f4 = par4;
            par4 = f7;
        }

        OffsetPositionTextureVertex positiontexturevertex = new OffsetPositionTextureVertex(par4, par5, par6, 0.0F, 0.0F);
        OffsetPositionTextureVertex positiontexturevertex1 = new OffsetPositionTextureVertex(f4, par5, par6, 0.0F, 8.0F);
        OffsetPositionTextureVertex positiontexturevertex2 = new OffsetPositionTextureVertex(f4, f5, par6, 8.0F, 8.0F);
        OffsetPositionTextureVertex positiontexturevertex3 = new OffsetPositionTextureVertex(par4, f5, par6, 8.0F, 0.0F);
        OffsetPositionTextureVertex positiontexturevertex4 = new OffsetPositionTextureVertex(par4, par5, f6, 0.0F, 0.0F);
        OffsetPositionTextureVertex positiontexturevertex5 = new OffsetPositionTextureVertex(f4, par5, f6, 0.0F, 8.0F);
        OffsetPositionTextureVertex positiontexturevertex6 = new OffsetPositionTextureVertex(f4, f5, f6, 8.0F, 8.0F);
        OffsetPositionTextureVertex positiontexturevertex7 = new OffsetPositionTextureVertex(par4, f5, f6, 8.0F, 0.0F);
        this.vertexPositions[0] = positiontexturevertex;
        this.vertexPositions[1] = positiontexturevertex1;
        this.vertexPositions[2] = positiontexturevertex2;
        this.vertexPositions[3] = positiontexturevertex3;
        this.vertexPositions[4] = positiontexturevertex4;
        this.vertexPositions[5] = positiontexturevertex5;
        this.vertexPositions[6] = positiontexturevertex6;
        this.vertexPositions[7] = positiontexturevertex7;
        this.quadList[0] = new TexturedQuad(new PositionTextureVertex[]{positiontexturevertex5, positiontexturevertex1, positiontexturevertex2, positiontexturevertex6}, par2 + par9 + par7, par3 + par9, par2 + par9 + par7 + par9, par3 + par9 + par8, par1ModelRenderer.textureWidth, par1ModelRenderer.textureHeight);
        this.quadList[1] = new TexturedQuad(new PositionTextureVertex[]{positiontexturevertex, positiontexturevertex4, positiontexturevertex7, positiontexturevertex3}, par2, par3 + par9, par2 + par9, par3 + par9 + par8, par1ModelRenderer.textureWidth, par1ModelRenderer.textureHeight);
        this.quadList[2] = new TexturedQuad(new PositionTextureVertex[]{positiontexturevertex5, positiontexturevertex4, positiontexturevertex, positiontexturevertex1}, topX, topY, topX + par7, topY + par9, par1ModelRenderer.textureWidth, par1ModelRenderer.textureHeight);
        this.quadList[3] = new TexturedQuad(new PositionTextureVertex[]{positiontexturevertex2, positiontexturevertex3, positiontexturevertex7, positiontexturevertex6}, botX, botY + par9, botX + par7, botY, par1ModelRenderer.textureWidth, par1ModelRenderer.textureHeight);
        this.quadList[4] = new TexturedQuad(new PositionTextureVertex[]{positiontexturevertex1, positiontexturevertex, positiontexturevertex3, positiontexturevertex2}, par2 + par9, par3 + par9, par2 + par9 + par7, par3 + par9 + par8, par1ModelRenderer.textureWidth, par1ModelRenderer.textureHeight);
        this.quadList[5] = new TexturedQuad(new PositionTextureVertex[]{positiontexturevertex4, positiontexturevertex5, positiontexturevertex6, positiontexturevertex7}, par2 + par9 + par7 + par9, par3 + par9, par2 + par9 + par7 + par9 + par7, par3 + par9 + par8, par1ModelRenderer.textureWidth, par1ModelRenderer.textureHeight);

        if (par1ModelRenderer.mirror) {
            for (int j1 = 0; j1 < this.quadList.length; ++j1) {
                this.quadList[j1].flipFace();
            }
        }
    }

    /**
     * Draw the six sided box defined by this ModelBox
     */
    @SideOnly(Side.CLIENT)
    @Override
    public void render(Tessellator par1Tessellator, float par2) {
        for (int i = 0; i < this.quadList.length; ++i) {
            this.quadList[i].draw(par1Tessellator, par2);
        }
    }

    public ModelRetexturedBoxSharpBend func_78244_a(String par1Str) {
        this.field_78247_g = par1Str;
        return this;
    }

    public void setLowerRotation(ModelRenderer par1ModelRenderer, float rotateAngleX) {
        float distanceMultiLower = 1.24F;

        float distanceMultiInnerLower = 0.94F;

        if(this.lowerRotation > 0){
            distanceMultiLower = 0.94F;
            distanceMultiInnerLower = 1.24F;
        }

        this.lowerRotation = rotateAngleX;

        this.vertexPositions[2].setOffsetVecY(this.lowerRotation * distanceMultiInnerLower);
        this.vertexPositions[3].setOffsetVecY(this.lowerRotation * distanceMultiInnerLower);
        this.vertexPositions[6].setOffsetVecY(-this.lowerRotation * distanceMultiLower);
        this.vertexPositions[7].setOffsetVecY(-this.lowerRotation * distanceMultiLower);

    }

    public void setUpperRotation(ModelRenderer par1ModelRenderer, float rotateAngleX) {
        float distanceMultiUpper = 1.24F;

        float distanceMultiInnerUpper = 0.94F;

        if(this.upperRotation > 0){
            distanceMultiUpper = 0.94F;
            distanceMultiInnerUpper = 1.24F;
        }

        this.upperRotation = rotateAngleX;

        this.vertexPositions[0].setOffsetVecY(-this.upperRotation * distanceMultiInnerUpper);
        this.vertexPositions[1].setOffsetVecY(-this.upperRotation * distanceMultiInnerUpper);
        this.vertexPositions[4].setOffsetVecY(this.upperRotation * distanceMultiUpper);
        this.vertexPositions[5].setOffsetVecY(this.upperRotation * distanceMultiUpper);

    }
}
