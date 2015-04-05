package com.chroma;

public class ChromaHSL extends ChromaColor {

    private double hsl_H;
    private double hsl_S;
    private double hsl_L;

    public ChromaHSL(double hsl_H_, double hsl_S_, double hsl_L_, double alpha_) {
        this.hsl_H = hsl_H_;
        this.hsl_S = hsl_S_;
        this.hsl_L = hsl_L_;
        this.alpha = alpha_;
    }

    public double[] getHSLComp() {
        return new double[] {hsl_H, hsl_S, hsl_L};
    }


    // CONVERSION METHODS
    /////////////////////////////////////////////////////////////////////////////////////

    public ChromaRGB getChromaRGB() {
        return getChromaHSV().getChromaRGB();
    }

    public ChromaHSL getChromaHSL() {
        return this;
    }

    public ChromaHSV getChromaHSV() {

        double hsl_H_ = ChromaUtil.clamp(this.hsl_H, 0, 360);
        double hsl_S_ = ChromaUtil.clamp(this.hsl_S, 0, 1);
        double hsl_L_ = ChromaUtil.clamp(this.hsl_L, 0, 1);

        hsl_S_ *= ((hsl_L_ < 0.5) ? hsl_L_ : 1 - hsl_L_);

        double hsv_S_ = (2 * hsl_S_) / (hsl_L_ + hsl_S_);
        double hsv_V_ = hsl_L_ + hsl_S_;

        return new ChromaHSV(hsl_H_, hsv_S_, hsv_V_, alpha);
    }

    public ChromaLAB getChromaLAB() {
        return getChromaHSV().getChromaLAB();
    }

    public ChromaLCH getChromaLCH() {
        return getChromaHSV().getChromaLCH();
    }

}



