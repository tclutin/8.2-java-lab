package org.example.tc.module;

public interface Contract
{
    boolean CheckFormat(String filePath);
    String GetDescription();
    void Execute(String filePath);
}