CREATE TABLE blood_marker_type (
    name VARCHAR(255) PRIMARY KEY,
    description TEXT,
    recommended_unit VARCHAR(50)
);

CREATE TYPE marker_flag_type AS ENUM (
    'LOW', 'NORMAL', 'HIGH'
);

CREATE TYPE severity_type AS ENUM (
    'MILD', 'MODERATE', 'SEVERE'
);

CREATE TABLE blood_work (
    id UUID PRIMARY KEY,
    user_id UUID NOT NULL,
    collected_date DATE,
    notes TEXT
);

CREATE TABLE blood_marker (
    id UUID PRIMARY KEY,
    blood_work_id UUID NOT NULL,
    name VARCHAR(255) NOT NULL,
    value DOUBLE PRECISION,
    unit VARCHAR(50),
    reference_range VARCHAR(255),
    flag marker_flag_type,
    CONSTRAINT fk_blood_work FOREIGN KEY (blood_work_id) REFERENCES blood_work(id) ON DELETE CASCADE,
    CONSTRAINT fk_blood_marker_type FOREIGN KEY (name) REFERENCES blood_marker_type(name)
);

CREATE TABLE sickness_record (
    id UUID PRIMARY KEY,
    user_id UUID NOT NULL,
    start_date DATE,
    end_date DATE,
    symptoms TEXT,
    diagnosis VARCHAR(255),
    severity severity_type
);

INSERT INTO blood_marker_type (name, description, recommended_unit) VALUES
    ('HEMOGLOBIN', 'Hemoglobin is a protein in red blood cells that carries oxygen.', 'g/dL'),
    ('HEMATOCRIT', 'The percentage of blood volume that is occupied by red blood cells.', '%'),
    ('RED_BLOOD_CELL_COUNT', 'The number of red blood cells in a volume of blood.', 'million/uL'),
    ('WHITE_BLOOD_CELL_COUNT', 'The number of white blood cells in a volume of blood.', 'thousand/uL'),
    ('PLATELET_COUNT', 'The number of platelets in a volume of blood.', 'thousand/uL'),
    ('MCV', 'Mean Corpuscular Volume - The average size of red blood cells.', 'fL'),
    ('MCH', 'Mean Corpuscular Hemoglobin - The average amount of hemoglobin per red blood cell.', 'pg'),
    ('MCHC', 'Mean Corpuscular Hemoglobin Concentration - The concentration of hemoglobin in red blood cells.', 'g/dL'),
    ('RDW', 'Red vascular Distribution Width - Measures the variation in red blood cell volume/size.', '%'),
    ('NEUTROPHILS', 'A type of white blood cell that leads your body''s immune response.', '%'),
    ('LYMPHOCYTES', 'A type of white blood cell that is fundamental to the immune system.', '%'),
    ('MONOCYTES', 'A type of white blood cell that fights off bacteria, viruses and fungi.', '%'),
    ('EOSINOPHILS', 'A type of white blood cell that fights disease.', '%'),
    ('BASOPHILS', 'A type of white blood cell produced in the bone marrow.', '%'),

    ('TOTAL_CHOLESTEROL', 'The sum of all cholesterol in your blood.', 'mg/dL'),
    ('LDL_CHOLESTEROL', 'Low-Density Lipoprotein - often called "bad" cholesterol.', 'mg/dL'),
    ('HDL_CHOLESTEROL', 'High-Density Lipoprotein - often called "good" cholesterol.', 'mg/dL'),
    ('TRIGLYCERIDES', 'A type of fat (lipid) found in your blood.', 'mg/dL'),
    ('NON_HDL_CHOLESTEROL', 'Your total cholesterol minus your HDL.', 'mg/dL'),
    ('VLDL_CHOLESTEROL', 'Very Low-Density Lipoprotein.', 'mg/dL'),

    ('GLUCOSE_FASTING', 'Blood sugar level after an overnight fast.', 'mg/dL'),
    ('HBA1C', 'Average blood sugar level over the past 2-3 months.', '%'),
    ('INSULIN_FASTING', 'Insulin level after fasting.', 'uIU/mL'),
    ('CREATININE', 'A waste product from normal breakdown of muscle tissue.', 'mg/dL'),
    ('BUN', 'Blood Urea Nitrogen - Measures the amount of nitrogen in your blood.', 'mg/dL'),
    ('BUN_CREATININE_RATIO', 'The ratio of BUN to Creatinine.', NULL),
    ('GFR', 'Glomerular Filtration Rate - A measure of how well your kidneys filter blood.', 'mL/min/1.73m^2'),
    ('SODIUM', 'An electrolyte that helps maintain fluid balance.', 'mmol/L'),
    ('POTASSIUM', 'An electrolyte that helps nerves and muscles.', 'mmol/L'),
    ('CHLORIDE', 'An electrolyte that helps maintain proper blood volume/pressure.', 'mmol/L'),
    ('CALCIUM', 'A mineral vital for healthy bones.', 'mg/dL'),
    ('CO2', 'Carbon Dioxide - part of electrolyte panel.', 'mmol/L'),
    ('URIC_ACID', 'A waste product created when the body breaks down purines.', 'mg/dL'),

    ('ALT', 'Alanine Aminotransferase - an enzyme found mostly in the liver.', 'IU/L'),
    ('AST', 'Aspartate Aminotransferase - an enzyme found in liver and other tissues.', 'IU/L'),
    ('ALP', 'Alkaline Phosphatase - an enzyme in the liver, bile ducts and bone.', 'IU/L'),
    ('BILIRUBIN_TOTAL', 'A yellow substance made during normal breakdown of red blood cells.', 'mg/dL'),
    ('BILIRUBIN_DIRECT', 'Bilirubin attached to glucuronic acid.', 'mg/dL'),
    ('PROTEIN_TOTAL', 'Measures the total amount of two classes of proteins found in the fluid portion of your blood: albumin and globulin.', 'g/dL'),
    ('ALBUMIN', 'A protein made by the liver.', 'g/dL'),
    ('GLOBULIN', 'A group of proteins in your blood.', 'g/dL'),
    ('ALBUMIN_GLOBULIN_RATIO', 'The ratio of albumin to globulin.', NULL),
    ('GGT', 'Gamma-Glutamyl Transferase - an enzyme found in many organs.', 'IU/L'),
    ('LDH', 'Lactate Dehydrogenase - an enzyme that helps convert sugar into energy.', 'IU/L'),

    ('TESTOSTERONE_TOTAL', 'The total amount of testosterone in the blood.', 'ng/dL'),
    ('TESTOSTERONE_FREE', 'The amount of testosterone not attached to proteins.', 'pg/mL'),
    ('ESTRADIOL', 'E2 - The primary form of estrogen.', 'pg/mL'),
    ('PROGESTERONE', 'A hormone that prepares the uterus for pregnancy.', 'ng/mL'),
    ('PROLACTIN', 'A hormone that causes breasts to grow and make milk.', 'ng/mL'),
    ('CORTISOL', 'Wait stress hormone.', 'ug/dL'),
    ('DHEA_S', 'A hormone that helps make other hormones.', 'ug/dL'),
    ('SHBG', 'Sex Hormone Binding Globulin - A protein that carries hormones.', 'nmol/L'),
    ('TSH', 'Thyroid Stimulating Hormone.', 'uIU/mL'),
    ('T3_FREE', 'Triiodothyronine - Active thyroid hormone.', 'pg/mL'),
    ('T4_FREE', 'Thyroxine - The main thyroid hormone.', 'ng/dL'),
    ('T3_REVERSE', 'Reverse T3 - Inactive form of T3.', 'ng/dL'),
    ('IGF_1', 'Insulin-like Growth Factor 1 - manages effects of growth hormone.', 'ng/mL'),
    ('FSH', 'Follicle Stimulating Hormone.', 'mIU/mL'),
    ('LH', 'Luteinizing Hormone.', 'mIU/mL'),

    ('VITAMIN_D_25_OH', 'The major circulating form of vitamin D.', 'ng/mL'),
    ('VITAMIN_B12', 'A vitamin important for metabolism.', 'pg/mL'),
    ('FOLATE', 'Vitamin B9.', 'ng/mL'),
    ('MAGNESIUM', 'An important mineral for many bodily processes.', 'mg/dL'),
    ('IRON', 'A mineral needed for hemoglobin.', 'ug/dL'),
    ('FERRITIN', 'A blood protein that contains iron.', 'ng/mL'),
    ('TIBC', 'Total Iron Binding Capacity.', 'ug/dL'),
    ('TRANSFERRIN_SATURATION', 'Percentage of transferrin saturated with iron.', '%'),
    ('ZINC', 'A trace mineral.', 'ug/dL'),
    ('COPPER', 'A trace mineral.', 'ug/dL'),

    ('CRP_HS', 'High-Sensitivity C-Reactive Protein - marker of inflammation.', 'mg/L'),
    ('HOMOCYSTEINE', 'An amino acid in the blood.', 'umol/L'),
    ('FIBRINOGEN', 'A protein that helps blood clot.', 'mg/dL'),
    ('APOLIPOPROTEIN_B', 'The main protein in LDL cholesterol.', 'mg/dL'),
    ('LIPOPROTEIN_A', 'A type of LDL cholesterol.', 'nmol/L'),

    ('OTHER', 'Other markers not listed.', NULL);
