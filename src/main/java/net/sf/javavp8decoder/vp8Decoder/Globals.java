/*    This file is part of javavp8decoder.

    javavp8decoder is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    javavp8decoder is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with javavp8decoder.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.sf.javavp8decoder.vp8Decoder;

public class Globals {

    public static final int DC_PRED = 0; /* predict DC using row above and
                                          * column
                                          * to the left */

    public static final int V_PRED = 1; /* predict rows using row above */

    public static final int H_PRED = 2; /* predict columns using column to the
                                         * left */

    public static final int TM_PRED = 3; /* propagate second differences a la
                                          * "true motion" */

    public static final int B_PRED = 4; /* each Y subblock is independently
                                         * predicted */

    public static String getModeAsString(int mode) {
        switch (mode) {
        case DC_PRED:
            return "DC_PRED";
        case V_PRED:
            return "V_PRED";
        case H_PRED:
            return "H_PRED";
        case TM_PRED:
            return "TM_PRED";
        case B_PRED:
            return "B_PRED";
        }
        return "not found";
    }

    /* intra_bmode */
    public static final int B_DC_PRED = 0; /* predict DC using row above and
                                            * column to the left */

    public static final int B_TM_PRED = 1; /* propagate second differences a la
                                            * "true motion" */

    public static final int B_VE_PRED = 2; /* predict rows using row above */

    public static final int B_HE_PRED = 3; /* predict columns using column to
                                            * the left */

    public static final int B_LD_PRED = 4; /* southwest (left and down) 45
                                            * degree diagonal prediction */

    public static final int B_RD_PRED = 5; /* southeast (right and down) "" */

    public static final int B_VR_PRED = 6; /* SSE (vertical right) diagonal
                                            * prediction */

    public static final int B_VL_PRED = 7; /* SSW (vertical left) "" */

    public static final int B_HD_PRED = 8; /* ESE (horizontal down) "" */

    public static final int B_HU_PRED = 9; /* ENE (horizontal up) "" */

    public static String getSubBlockModeAsString(int mode) {
        switch (mode) {
        case B_DC_PRED:
            return "B_DC_PRED";
        case B_TM_PRED:
            return "B_TM_PRED";
        case B_VE_PRED:
            return "B_VE_PRED";
        case B_HE_PRED:
            return "B_HE_PRED";
        case B_LD_PRED:
            return "B_LD_PRED";
        case B_RD_PRED:
            return "B_RD_PRED";
        case B_VR_PRED:
            return "B_VR_PRED";
        case B_VL_PRED:
            return "B_VL_PRED";
        case B_HD_PRED:
            return "B_HD_PRED";
        case B_HU_PRED:
            return "B_HU_PRED";
        }
        return "not found";
    }

    public static final int MAX_MB_SEGMENTS = 4;

    public static final int MB_LVL_MAX = 2;

    public static int[] vp8MacroBlockFeatureDataBits = {
        7, 6
    };

    public static final int MB_FEATURE_TREE_PROBS = 3;

    public static int macroBlockSegmentTree[] = {
        2, 4,
        /* root: "0", "1" subtrees */
        -0, -1,
        /* "00" = 0th value, "01" = 1st value */
        -2, -3
            /* "10" = 2nd value, "11" = 3rd value */
    };

    public static int vp8KeyFrameYModeTree[] = {
        -B_PRED, 2, 4, 6, -DC_PRED, -V_PRED, -H_PRED, -TM_PRED
    };

    public static int vp8SubBlockModeTree[] = {
        -B_DC_PRED, 2, /* B_DC_PRED =
                        * "0" */
        -B_TM_PRED, 4, /* B_TM_PRED = "10" */
        -B_VE_PRED, 6, /* B_VE_PRED = "110" */
        8, 12, -B_HE_PRED, 10, /* B_HE_PRED = "1110" */
        -B_RD_PRED, -B_VR_PRED, /* B_RD_PRED = "111100", B_VR_PRED = "111101" */
        -B_LD_PRED, 14, /* B_LD_PRED = "111110" */
        -B_VL_PRED, 16, /* B_VL_PRED = "1111110" */
        -B_HD_PRED, -B_HU_PRED /* HD = "11111110", HU = "11111111" */
    };

    public static int vp8KeyFrameYModeProb[] = {
        145, 156, 163, 128
    };

    // uv
    public static int vp8UVModeTree[] = {
        -DC_PRED, 2, /* root: DC_PRED = "0",
                      * "1" subtree */
        -V_PRED, 4, /* "1" subtree: V_PRED = "10", "11" subtree */
        -H_PRED, -TM_PRED /* "11" subtree: H_PRED = "110", TM_PRED = "111" */
    };

    public static int vp8KeyFrameUVModeProb[] = {
        142, 114, 183
    };

    public static int vp8KeyFrameSubBlockModeProb[][][] = {
        {
            {
                231, 120, 48, 89, 115, 113, 120, 152, 112
            }, {
                152, 179, 64, 126, 170, 118, 46, 70, 95
            }, {
                175, 69, 143, 80, 85, 82, 72, 155, 103
            }, {
                56, 58, 10, 171, 218, 189, 17, 13, 152
            }, {
                144, 71, 10, 38, 171, 213, 144, 34, 26
            }, {
                114, 26, 17, 163, 44, 195, 21, 10, 173
            }, {
                121, 24, 80, 195, 26, 62, 44, 64, 85
            }, {
                170, 46, 55, 19, 136, 160, 33, 206, 71
            }, {
                63, 20, 8, 114, 114, 208, 12, 9, 226
            }, {
                81, 40, 11, 96, 182, 84, 29, 16, 36
            }
        }, {
            {
                134, 183, 89, 137, 98, 101, 106, 165, 148
            }, {
                72, 187, 100, 130, 157, 111, 32, 75, 80
            }, {
                66, 102, 167, 99, 74, 62, 40, 234, 128
            }, {
                41, 53, 9, 178, 241, 141, 26, 8, 107
            }, {
                104, 79, 12, 27, 217, 255, 87, 17, 7
            }, {
                74, 43, 26, 146, 73, 166, 49, 23, 157
            }, {
                65, 38, 105, 160, 51, 52, 31, 115, 128
            }, {
                87, 68, 71, 44, 114, 51, 15, 186, 23
            }, {
                47, 41, 14, 110, 182, 183, 21, 17, 194
            }, {
                66, 45, 25, 102, 197, 189, 23, 18, 22
            }
        }, {
            {
                88, 88, 147, 150, 42, 46, 45, 196, 205
            }, {
                43, 97, 183, 117, 85, 38, 35, 179, 61
            }, {
                39, 53, 200, 87, 26, 21, 43, 232, 171
            }, {
                56, 34, 51, 104, 114, 102, 29, 93, 77
            }, {
                107, 54, 32, 26, 51, 1, 81, 43, 31
            }, {
                39, 28, 85, 171, 58, 165, 90, 98, 64
            }, {
                34, 22, 116, 206, 23, 34, 43, 166, 73
            }, {
                68, 25, 106, 22, 64, 171, 36, 225, 114
            }, {
                34, 19, 21, 102, 132, 188, 16, 76, 124
            }, {
                62, 18, 78, 95, 85, 57, 50, 48, 51
            }
        }, {
            {
                193, 101, 35, 159, 215, 111, 89, 46, 111
            }, {
                60, 148, 31, 172, 219, 228, 21, 18, 111
            }, {
                112, 113, 77, 85, 179, 255, 38, 120, 114
            }, {
                40, 42, 1, 196, 245, 209, 10, 25, 109
            }, {
                100, 80, 8, 43, 154, 1, 51, 26, 71
            }, {
                88, 43, 29, 140, 166, 213, 37, 43, 154
            }, {
                61, 63, 30, 155, 67, 45, 68, 1, 209
            }, {
                142, 78, 78, 16, 255, 128, 34, 197, 171
            }, {
                41, 40, 5, 102, 211, 183, 4, 1, 221
            }, {
                51, 50, 17, 168, 209, 192, 23, 25, 82
            }
        }, {
            {
                125, 98, 42, 88, 104, 85, 117, 175, 82
            }, {
                95, 84, 53, 89, 128, 100, 113, 101, 45
            }, {
                75, 79, 123, 47, 51, 128, 81, 171, 1
            }, {
                57, 17, 5, 71, 102, 57, 53, 41, 49
            }, {
                115, 21, 2, 10, 102, 255, 166, 23, 6
            }, {
                38, 33, 13, 121, 57, 73, 26, 1, 85
            }, {
                41, 10, 67, 138, 77, 110, 90, 47, 114
            }, {
                101, 29, 16, 10, 85, 128, 101, 196, 26
            }, {
                57, 18, 10, 102, 102, 213, 34, 20, 43
            }, {
                117, 20, 15, 36, 163, 128, 68, 1, 26
            }
        }, {
            {
                138, 31, 36, 171, 27, 166, 38, 44, 229
            }, {
                67, 87, 58, 169, 82, 115, 26, 59, 179
            }, {
                63, 59, 90, 180, 59, 166, 93, 73, 154
            }, {
                40, 40, 21, 116, 143, 209, 34, 39, 175
            }, {
                57, 46, 22, 24, 128, 1, 54, 17, 37
            }, {
                47, 15, 16, 183, 34, 223, 49, 45, 183
            }, {
                46, 17, 33, 183, 6, 98, 15, 32, 183
            }, {
                65, 32, 73, 115, 28, 128, 23, 128, 205
            }, {
                40, 3, 9, 115, 51, 192, 18, 6, 223
            }, {
                87, 37, 9, 115, 59, 77, 64, 21, 47
            }
        }, {
            {
                104, 55, 44, 218, 9, 54, 53, 130, 226
            }, {
                64, 90, 70, 205, 40, 41, 23, 26, 57
            }, {
                54, 57, 112, 184, 5, 41, 38, 166, 213
            }, {
                30, 34, 26, 133, 152, 116, 10, 32, 134
            }, {
                75, 32, 12, 51, 192, 255, 160, 43, 51
            }, {
                39, 19, 53, 221, 26, 114, 32, 73, 255
            }, {
                31, 9, 65, 234, 2, 15, 1, 118, 73
            }, {
                88, 31, 35, 67, 102, 85, 55, 186, 85
            }, {
                56, 21, 23, 111, 59, 205, 45, 37, 192
            }, {
                55, 38, 70, 124, 73, 102, 1, 34, 98
            }
        }, {
            {
                102, 61, 71, 37, 34, 53, 31, 243, 192
            }, {
                69, 60, 71, 38, 73, 119, 28, 222, 37
            }, {
                68, 45, 128, 34, 1, 47, 11, 245, 171
            }, {
                62, 17, 19, 70, 146, 85, 55, 62, 70
            }, {
                75, 15, 9, 9, 64, 255, 184, 119, 16
            }, {
                37, 43, 37, 154, 100, 163, 85, 160, 1
            }, {
                63, 9, 92, 136, 28, 64, 32, 201, 85
            }, {
                86, 6, 28, 5, 64, 255, 25, 248, 1
            }, {
                56, 8, 17, 132, 137, 255, 55, 116, 128
            }, {
                58, 15, 20, 82, 135, 57, 26, 121, 40
            }
        }, {
            {
                164, 50, 31, 137, 154, 133, 25, 35, 218
            }, {
                51, 103, 44, 131, 131, 123, 31, 6, 158
            }, {
                86, 40, 64, 135, 148, 224, 45, 183, 128
            }, {
                22, 26, 17, 131, 240, 154, 14, 1, 209
            }, {
                83, 12, 13, 54, 192, 255, 68, 47, 28
            }, {
                45, 16, 21, 91, 64, 222, 7, 1, 197
            }, {
                56, 21, 39, 155, 60, 138, 23, 102, 213
            }, {
                85, 26, 85, 85, 128, 128, 32, 146, 171
            }, {
                18, 11, 7, 63, 144, 171, 4, 4, 246
            }, {
                35, 27, 10, 146, 174, 171, 12, 26, 128
            }
        }, {
            {
                190, 80, 35, 99, 180, 80, 126, 54, 45
            }, {
                85, 126, 47, 87, 176, 51, 41, 20, 32
            }, {
                101, 75, 128, 139, 118, 146, 116, 128, 85
            }, {
                56, 41, 15, 176, 236, 85, 37, 9, 62
            }, {
                146, 36, 19, 30, 171, 255, 97, 27, 20
            }, {
                71, 30, 17, 119, 118, 255, 17, 18, 138
            }, {
                101, 38, 60, 138, 55, 70, 43, 26, 142
            }, {
                138, 45, 61, 62, 219, 1, 81, 188, 64
            }, {
                32, 41, 20, 117, 151, 142, 20, 21, 163
            }, {
                112, 19, 12, 61, 195, 128, 48, 4, 24
            }
        }
    };

    static int vp8CoefUpdateProbs[][][][] = new int[][][][] {
        {
            {
                {
                    255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }
            }, {
                {
                    176, 246, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    223, 241, 252, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    249, 253, 253, 255, 255, 255, 255, 255, 255, 255, 255
                }
            }, {
                {
                    255, 244, 252, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    234, 254, 254, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    253, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }
            }, {
                {
                    255, 246, 254, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    239, 253, 254, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    254, 255, 254, 255, 255, 255, 255, 255, 255, 255, 255
                }
            }, {
                {
                    255, 248, 254, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    251, 255, 254, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }
            }, {
                {
                    255, 253, 254, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    251, 254, 254, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    254, 255, 254, 255, 255, 255, 255, 255, 255, 255, 255
                }
            }, {
                {
                    255, 254, 253, 255, 254, 255, 255, 255, 255, 255, 255
                }, {
                    250, 255, 254, 255, 254, 255, 255, 255, 255, 255, 255
                },

                {
                    254, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }
            }, {
                {
                    255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }
            }
        }, {
            {
                {
                    217, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    225, 252, 241, 253, 255, 255, 254, 255, 255, 255, 255
                }, {
                    234, 250, 241, 250, 253, 255, 253, 254, 255, 255, 255
                }
            }, {
                {
                    255, 254, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    223, 254, 254, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    238, 253, 254, 254, 255, 255, 255, 255, 255, 255, 255
                }
            }, {
                {
                    255, 248, 254, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    249, 254, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }
            }, {
                {
                    255, 253, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    247, 254, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }
            }, {
                {
                    255, 253, 254, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    252, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }
            }, {
                {
                    255, 254, 254, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    253, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }
            }, {
                {
                    255, 254, 253, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    250, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    254, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }
            }, {
                {
                    255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }
            }
        }, {
            {
                {
                    186, 251, 250, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    234, 251, 244, 254, 255, 255, 255, 255, 255, 255, 255
                }, {
                    251, 251, 243, 253, 254, 255, 254, 255, 255, 255, 255
                }
            }, {

                {
                    255, 253, 254, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    236, 253, 254, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    251, 253, 253, 254, 254, 255, 255, 255, 255, 255, 255
                }
            }, {
                {
                    255, 254, 254, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    254, 254, 254, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }
            }, {
                {
                    255, 254, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    254, 254, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    254, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }
            }, {
                {
                    255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    254, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }
            }, {
                {
                    255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }
            }, {
                {
                    255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }
            }, {
                {
                    255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }
            }
        }, {
            {
                {
                    248, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    250, 254, 252, 254, 255, 255, 255, 255, 255, 255, 255
                }, {
                    248, 254, 249, 253, 255, 255, 255, 255, 255, 255, 255
                }
            }, {
                {
                    255, 253, 253, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    246, 253, 253, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    252, 254, 251, 254, 254, 255, 255, 255, 255, 255, 255
                }
            }, {
                {
                    255, 254, 252, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    248, 254, 253, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    253, 255, 254, 254, 255, 255, 255, 255, 255, 255, 255
                }
            }, {
                {
                    255, 251, 254, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    245, 251, 254, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    253, 253, 254, 255, 255, 255, 255, 255, 255, 255, 255
                }
            }, {

                {
                    255, 251, 253, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    252, 253, 254, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    255, 254, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }
            }, {
                {
                    255, 252, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    249, 255, 254, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    255, 255, 254, 255, 255, 255, 255, 255, 255, 255, 255
                }
            }, {
                {
                    255, 255, 253, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    250, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }
            }, {
                {
                    255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    254, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }, {
                    255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255
                }
            }
        }
    };

    public static int[][][][] getDefaultCoefProbs() {
        int r[][][][] = new int[vp8DefaultCoefProbs.length][vp8DefaultCoefProbs[0].length][vp8DefaultCoefProbs[0][0].length][vp8DefaultCoefProbs[0][0][0].length];
        for (int i = 0; i < vp8DefaultCoefProbs.length; i++)
            for (int j = 0; j < vp8DefaultCoefProbs[0].length; j++)
                for (int k = 0; k < vp8DefaultCoefProbs[0][0].length; k++)
                    for (int l = 0; l < vp8DefaultCoefProbs[0][0][0].length; l++)
                        r[i][j][k][l] = vp8DefaultCoefProbs[i][j][k][l];
        return r;
    }

    private static int vp8DefaultCoefProbs[][][][] = new int[][][][] {
        {
            {
                {
                    128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128
                }, {
                    128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128
                }, {
                    128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128
                }
            }, {
                {
                    253, 136, 254, 255, 228, 219, 128, 128, 128, 128, 128
                }, {
                    189, 129, 242, 255, 227, 213, 255, 219, 128, 128, 128
                }, {
                    106, 126, 227, 252, 214, 209, 255, 255, 128, 128, 128
                }
            }, {
                {
                    1, 98, 248, 255, 236, 226, 255, 255, 128, 128, 128
                }, {
                    181, 133, 238, 254, 221, 234, 255, 154, 128, 128, 128
                }, {
                    78, 134, 202, 247, 198, 180, 255, 219, 128, 128, 128
                }
            }, {
                {
                    1, 185, 249, 255, 243, 255, 128, 128, 128, 128, 128
                }, {
                    184, 150, 247, 255, 236, 224, 128, 128, 128, 128, 128
                }, {
                    77, 110, 216, 255, 236, 230, 128, 128, 128, 128, 128
                }
            }, {
                {
                    1, 101, 251, 255, 241, 255, 128, 128, 128, 128, 128
                }, {
                    170, 139, 241, 252, 236, 209, 255, 255, 128, 128, 128
                }, {
                    37, 116, 196, 243, 228, 255, 255, 255, 128, 128, 128
                }
            }, {

                {
                    1, 204, 254, 255, 245, 255, 128, 128, 128, 128, 128
                }, {
                    207, 160, 250, 255, 238, 128, 128, 128, 128, 128, 128
                }, {
                    102, 103, 231, 255, 211, 171, 128, 128, 128, 128, 128
                }
            }, {
                {
                    1, 152, 252, 255, 240, 255, 128, 128, 128, 128, 128
                }, {
                    177, 135, 243, 255, 234, 225, 128, 128, 128, 128, 128
                }, {
                    80, 129, 211, 255, 194, 224, 128, 128, 128, 128, 128
                }
            }, {
                {
                    1, 1, 255, 128, 128, 128, 128, 128, 128, 128, 128
                }, {
                    246, 1, 255, 128, 128, 128, 128, 128, 128, 128, 128
                }, {
                    255, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128
                }
            }
        }, {
            {
                {
                    198, 35, 237, 223, 193, 187, 162, 160, 145, 155, 62
                }, {
                    131, 45, 198, 221, 172, 176, 220, 157, 252, 221, 1
                }, {
                    68, 47, 146, 208, 149, 167, 221, 162, 255, 223, 128
                }
            }, {
                {
                    1, 149, 241, 255, 221, 224, 255, 255, 128, 128, 128
                }, {
                    184, 141, 234, 253, 222, 220, 255, 199, 128, 128, 128
                }, {
                    81, 99, 181, 242, 176, 190, 249, 202, 255, 255, 128
                }
            }, {
                {
                    1, 129, 232, 253, 214, 197, 242, 196, 255, 255, 128
                }, {
                    99, 121, 210, 250, 201, 198, 255, 202, 128, 128, 128
                }, {
                    23, 91, 163, 242, 170, 187, 247, 210, 255, 255, 128
                }
            }, {
                {
                    1, 200, 246, 255, 234, 255, 128, 128, 128, 128, 128
                }, {
                    109, 178, 241, 255, 231, 245, 255, 255, 128, 128, 128
                }, {
                    44, 130, 201, 253, 205, 192, 255, 255, 128, 128, 128
                }
            }, {
                {
                    1, 132, 239, 251, 219, 209, 255, 165, 128, 128, 128
                }, {
                    94, 136, 225, 251, 218, 190, 255, 255, 128, 128, 128
                }, {
                    22, 100, 174, 245, 186, 161, 255, 199, 128, 128, 128
                }
            }, {
                {
                    1, 182, 249, 255, 232, 235, 128, 128, 128, 128, 128
                }, {
                    124, 143, 241, 255, 227, 234, 128, 128, 128, 128, 128
                }, {
                    35, 77, 181, 251, 193, 211, 255, 205, 128, 128, 128
                }
            }, {
                {
                    1, 157, 247, 255, 236, 231, 255, 255, 128, 128, 128
                }, {
                    121, 141, 235, 255, 225, 227, 255, 255, 128, 128, 128
                }, {
                    45, 99, 188, 251, 195, 217, 255, 224, 128, 128, 128
                }
            }, {
                {
                    1, 1, 251, 255, 213, 255, 128, 128, 128, 128, 128
                }, {
                    203, 1, 248, 255, 255, 128, 128, 128, 128, 128, 128
                }, {
                    137, 1, 177, 255, 224, 255, 128, 128, 128, 128, 128
                }
            }
        },

        {
            {
                {
                    253, 9, 248, 251, 207, 208, 255, 192, 128, 128, 128
                }, {
                    175, 13, 224, 243, 193, 185, 249, 198, 255, 255, 128
                }, {
                    73, 17, 171, 221, 161, 179, 236, 167, 255, 234, 128
                }
            }, {
                {
                    1, 95, 247, 253, 212, 183, 255, 255, 128, 128, 128
                }, {
                    239, 90, 244, 250, 211, 209, 255, 255, 128, 128, 128
                }, {
                    155, 77, 195, 248, 188, 195, 255, 255, 128, 128, 128
                }
            }, {
                {
                    1, 24, 239, 251, 218, 219, 255, 205, 128, 128, 128
                }, {
                    201, 51, 219, 255, 196, 186, 128, 128, 128, 128, 128
                }, {
                    69, 46, 190, 239, 201, 218, 255, 228, 128, 128, 128
                }
            }, {
                {
                    1, 191, 251, 255, 255, 128, 128, 128, 128, 128, 128
                }, {
                    223, 165, 249, 255, 213, 255, 128, 128, 128, 128, 128
                }, {
                    141, 124, 248, 255, 255, 128, 128, 128, 128, 128, 128
                }
            }, {
                {
                    1, 16, 248, 255, 255, 128, 128, 128, 128, 128, 128
                }, {
                    190, 36, 230, 255, 236, 255, 128, 128, 128, 128, 128
                }, {
                    149, 1, 255, 128, 128, 128, 128, 128, 128, 128, 128
                }
            }, {
                {
                    1, 226, 255, 128, 128, 128, 128, 128, 128, 128, 128
                }, {
                    247, 192, 255, 128, 128, 128, 128, 128, 128, 128, 128
                }, {
                    240, 128, 255, 128, 128, 128, 128, 128, 128, 128, 128
                }
            }, {
                {
                    1, 134, 252, 255, 255, 128, 128, 128, 128, 128, 128
                }, {
                    213, 62, 250, 255, 255, 128, 128, 128, 128, 128, 128
                }, {
                    55, 93, 255, 128, 128, 128, 128, 128, 128, 128, 128
                }
            }, {
                {
                    128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128
                }, {
                    128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128
                }, {
                    128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128
                }
            }
        }, {
            {
                {
                    202, 24, 213, 235, 186, 191, 220, 160, 240, 175, 255
                }, {
                    126, 38, 182, 232, 169, 184, 228, 174, 255, 187, 128
                }, {
                    61, 46, 138, 219, 151, 178, 240, 170, 255, 216, 128
                }
            }, {
                {
                    1, 112, 230, 250, 199, 191, 247, 159, 255, 255, 128
                }, {
                    166, 109, 228, 252, 211, 215, 255, 174, 128, 128, 128
                }, {
                    39, 77, 162, 232, 172, 180, 245, 178, 255, 255, 128
                }
            }, {
                {
                    1, 52, 220, 246, 198, 199, 249, 220, 255, 255, 128
                }, {
                    124, 74, 191, 243, 183, 193, 250, 221, 255, 255, 128
                }, {
                    24, 71, 130, 219, 154, 170, 243, 182, 255, 255, 128
                }

            }, {
                {
                    1, 182, 225, 249, 219, 240, 255, 224, 128, 128, 128
                }, {
                    149, 150, 226, 252, 216, 205, 255, 171, 128, 128, 128
                }, {
                    28, 108, 170, 242, 183, 194, 254, 223, 255, 255, 128
                }
            }, {
                {
                    1, 81, 230, 252, 204, 203, 255, 192, 128, 128, 128
                }, {
                    123, 102, 209, 247, 188, 196, 255, 233, 128, 128, 128
                }, {
                    20, 95, 153, 243, 164, 173, 255, 203, 128, 128, 128
                }
            }, {
                {
                    1, 222, 248, 255, 216, 213, 128, 128, 128, 128, 128
                }, {
                    168, 175, 246, 252, 235, 205, 255, 255, 128, 128, 128
                }, {
                    47, 116, 215, 255, 211, 212, 255, 255, 128, 128, 128
                }
            }, {
                {
                    1, 121, 236, 253, 212, 214, 255, 255, 128, 128, 128
                }, {
                    141, 84, 213, 252, 201, 202, 255, 219, 128, 128, 128
                }, {
                    42, 80, 160, 240, 162, 185, 255, 205, 128, 128, 128
                }
            }, {
                {
                    1, 1, 255, 128, 128, 128, 128, 128, 128, 128, 128
                }, {
                    244, 1, 255, 128, 128, 128, 128, 128, 128, 128, 128
                }, {
                    238, 1, 255, 128, 128, 128, 128, 128, 128, 128, 128
                }
            }
        }
    };

    public static final int DCT_0 = 0; /* value 0 */

    public static final int DCT_1 = 1; /* 1 */

    public static final int DCT_2 = 2; /* 2 */

    public static final int DCT_3 = 3; /* 3 */

    public static final int DCT_4 = 4; /* 4 */

    public static final int dct_cat1 = 5; /* range 5 - 6 (size 2) */

    public static final int dct_cat2 = 6; /* 7 - 10 (4) */

    public static final int dct_cat3 = 7; /* 11 - 18 (8) */

    public static final int dct_cat4 = 8; /* 19 - 34 (16) */

    public static final int dct_cat5 = 9; /* 35 - 66 (32) */

    public static final int dct_cat6 = 10; /* 67 - 2048 (1982) */

    public static final int dct_eob = 11; /* end of block */

    public static final int vp8CoefTree[] = {
        -dct_eob, 2, /* eob = "0" */
        -DCT_0, 4, /* 0 = "10" */
        -DCT_1, 6, /* 1 = "110" */
        8, 12, -DCT_2, 10, /* 2 = "11100" */
        -DCT_3, -DCT_4, /* 3 = "111010", 4 = "111011" */
        14, 16, -dct_cat1, -dct_cat2, /* cat1 = "111100", cat2 = "111101" */
        18, 20, -dct_cat3, -dct_cat4, /* cat3 = "1111100", cat4 = "1111101" */
        -dct_cat5, -dct_cat6 /* cat4 = "1111110", cat4 = "1111111" */
    };

    public static final int vp8CoefTreeNoEOB[] = {
        // -dct_eob, 2, /* eob = "0" */
        -DCT_0, 4, /* 0 = "10" */
        -DCT_1, 6, /* 1 = "110" */
        8, 12, -DCT_2, 10, /* 2 = "11100" */
        -DCT_3, -DCT_4, /* 3 = "111010", 4 = "111011" */
        14, 16, -dct_cat1, -dct_cat2, /* cat1 = "111100", cat2 = "111101" */
        18, 20, -dct_cat3, -dct_cat4, /* cat3 = "1111100", cat4 = "1111101" */
        -dct_cat5, -dct_cat6 /* cat4 = "1111110", cat4 = "1111111" */
    };

    public final static int Pcat1[] = {
        159, 0
    };

    public final static int Pcat2[] = {
        165, 145, 0
    };

    public final static int Pcat3[] = {
        173, 148, 140, 0
    };

    public final static int Pcat4[] = {
        176, 155, 140, 135, 0
    };

    public final static int Pcat5[] = {
        180, 157, 141, 134, 130, 0
    };

    public final static int Pcat6[] = {
        254, 254, 243, 230, 196, 177, 153, 140, 133, 130, 129, 0
    };

    public static final int vp8CoefBands[] = {
        0, 1, 2, 3, 6, 4, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7
    };

    public static final int vp8defaultZigZag1d[] = {
        0, 1, 4, 8, 5, 2, 3, 6, 9, 12, 13, 10, 7, 11, 14, 15,
    };

    public static final int vp8dxBitreaderNorm[] = {
        0, 7, 6, 6, 5, 5, 5, 5, 4, 4, 4, 4, 4, 4, 4, 4, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2,
        2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
        1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };

    public static final int vp8DcQLookup[] = {
        4, 5, 6, 7, 8, 9, 10, 10, 11, 12, 13, 14, 15, 16, 17, 17, 18, 19, 20, 20, 21, 21, 22, 22, 23, 23, 24, 25, 25, 26, 27,
        28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55,
        56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 76, 77, 78, 79, 80, 81, 82, 83, 84,
        85, 86, 87, 88, 89, 91, 93, 95, 96, 98, 100, 101, 102, 104, 106, 108, 110, 112, 114, 116, 118, 122, 124, 126, 128, 130,
        132, 134, 136, 138, 140, 143, 145, 148, 151, 154, 157,
    };

    public static final int vp8AcQLookup[] = {
        4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34,
        35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 60, 62, 64, 66, 68, 70,
        72, 74, 76, 78, 80, 82, 84, 86, 88, 90, 92, 94, 96, 98, 100, 102, 104, 106, 108, 110, 112, 114, 116, 119, 122, 125, 128,
        131, 134, 137, 140, 143, 146, 149, 152, 155, 158, 161, 164, 167, 170, 173, 177, 181, 185, 189, 193, 197, 201, 205, 209,
        213, 217, 221, 225, 229, 234, 239, 245, 249, 254, 259, 264, 269, 274, 279, 284,
    };

    public static String toHex(int c) {
        String r = new String();
        r = String.format("%1$#x ", c);
        return r;
    }

    // clamp between 0 and value
    public static int clamp(int input, int value) {
        int r = input;
        if (r > value)
            r = value;
        if (r < 0)
            r = 0;
        return r;
    }

}
