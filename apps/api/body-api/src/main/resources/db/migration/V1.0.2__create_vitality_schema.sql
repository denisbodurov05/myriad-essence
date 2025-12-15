CREATE TABLE biometric_reading (
    id UUID PRIMARY KEY,
    user_id UUID NOT NULL,
    measured_at TIMESTAMP WITH TIME ZONE,
    type VARCHAR(50),
    value1 DOUBLE PRECISION,
    value2 DOUBLE PRECISION,
    source VARCHAR(255)
);
