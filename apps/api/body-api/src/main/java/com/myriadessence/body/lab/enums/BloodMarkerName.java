package com.myriadessence.body.lab.enums;

public enum BloodMarkerName {
    // === Complete Blood Count (CBC) ===
    HEMOGLOBIN,
    HEMATOCRIT,
    RED_BLOOD_CELL_COUNT,
    WHITE_BLOOD_CELL_COUNT,
    PLATELET_COUNT,
    MCV, // Mean Corpuscular Volume
    MCH, // Mean Corpuscular Hemoglobin
    MCHC, // Mean Corpuscular Hemoglobin Concentration
    RDW, // Red Cell Distribution Width
    NEUTROPHILS,
    LYMPHOCYTES,
    MONOCYTES,
    EOSINOPHILS,
    BASOPHILS,

    // === Lipid Panel ===
    TOTAL_CHOLESTEROL,
    LDL_CHOLESTEROL,
    HDL_CHOLESTEROL,
    TRIGLYCERIDES,
    NON_HDL_CHOLESTEROL,
    VLDL_CHOLESTEROL,

    // === Metabolic & Kidney Function ===
    GLUCOSE_FASTING,
    HBA1C,
    INSULIN_FASTING,
    CREATININE,
    BUN, // Blood Urea Nitrogen
    BUN_CREATININE_RATIO,
    GFR, // Glomerular Filtration Rate
    SODIUM,
    POTASSIUM,
    CHLORIDE,
    CALCIUM,
    CO2,
    URIC_ACID,

    // === Liver Function ===
    ALT, // Alanine Aminotransferase
    AST, // Aspartate Aminotransferase
    ALP, // Alkaline Phosphatase
    BILIRUBIN_TOTAL,
    BILIRUBIN_DIRECT,
    PROTEIN_TOTAL,
    ALBUMIN,
    GLOBULIN,
    ALBUMIN_GLOBULIN_RATIO,
    GGT, // Gamma-Glutamyl Transferase
    LDH, // Lactate Dehydrogenase

    // === Hormones ===
    TESTOSTERONE_TOTAL,
    TESTOSTERONE_FREE,
    ESTRADIOL, // E2
    PROGESTERONE,
    PROLACTIN,
    CORTISOL,
    DHEA_S,
    SHBG, // Sex Hormone Binding Globulin
    TSH, // Thyroid Stimulating Hormone
    T3_FREE,
    T4_FREE,
    T3_REVERSE,
    IGF_1, // Insulin-Like Growth Factor 1
    FSH, // Follicle Stimulating Hormone
    LH, // Luteinizing Hormone

    // === Vitamins & Minerals ===
    VITAMIN_D_25_OH,
    VITAMIN_B12,
    FOLATE, // Vitamin B9
    MAGNESIUM,
    IRON,
    FERRITIN,
    TIBC, // Total Iron Binding Capacity
    TRANSFERRIN_SATURATION,
    ZINC,
    COPPER,

    // === Inflammation & Cardiovascular Risk ===
    CRP_HS, // High-Sensitivity C-Reactive Protein
    HOMOCYSTEINE,
    FIBRINOGEN,
    APOLIPOPROTEIN_B, // ApoB
    LIPOPROTEIN_A,

    OTHER
}
