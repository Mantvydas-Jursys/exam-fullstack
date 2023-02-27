function AddNewInventory() {


    return (

        <div>

            <h1>Prideti nauja sandeli</h1>

            <form>
                <label>
                    Pavadinimas:
                    <input type="text" name="Pavadinimas" placeholder="Pavadinimas"/>
                </label>

                <label>
                    Svoris:
                    <input type="number" name="Svoris" placeholder="Svoris"/>
                </label>

                <label>
                    Talpinimo Sektorius:
                    <input type="number" name="Talpinimo Sektorius" placeholder="Talpinimo Sektorius"/>
                </label>

                <label>
                    Patalpinimo data:
                    <input type="date" name="Patalpinimo data" placeholder="Patalpinimo data"/>
                </label>
               
                <input type="submit" value="Submit" />
            </form>

        </div>

    )

}

export default AddNewInventory