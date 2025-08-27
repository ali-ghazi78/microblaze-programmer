# MicroBlaze Programmer (JavaFX Tool)

A **JavaFX desktop application** that simplifies programming for Xilinx **MicroBlaze soft processors** by providing a graphical interface to Xilinx command-line tools (`data2mem` and `promgen`).  

The tool helps combine `.elf`, `.bmm`, and `.bit` files into a final FPGA bitstream and optionally generate PROM files.

---

## 📌 Features
- Select and save paths for:
  - **BIT** file (`.bit`)
  - **ELF** file (`.elf`)
  - **BMM** file (`.bmm`)
  - **Xilinx settings64.bat** (or `settings32.bat`)
  - **Output folder**
- Run **data2mem** to merge `.elf` with `.bit` based on `.bmm`.  
- Run **promgen** to generate PROM files in `.bin` format.  
- **"All" button** executes both steps in sequence.  
- Saves previously selected paths in text files (`*_path.text`) for easy reuse.  
- Combo box for selecting PROM size (powers of two).  
- About dialog with author info.  

---

## 📂 Project Structure
- **`Controller.java`**  
  - Handles all GUI logic (buttons, file choosers, checkboxes, running commands).  
- **`Main.java`**  
  - JavaFX entry point, loads `sample.fxml`, sets up the main window.  
- **`sample.fxml`**  
  - Defines the GUI layout (not included in your snippet but referenced in code).  
- **`icon.png`**  
  - Window icon.  

---

## 🔧 Requirements
- **Java 8+** (tested with JavaFX 8)  
- **Xilinx ISE / EDK 14.7** installed  
  - Path to `settings64.bat` or `settings32.bat` must be set in the tool  

---

## 🚀 Usage
1. Launch the program:  
   ```bash
   java -jar MicroBlazeProgrammer.jar
