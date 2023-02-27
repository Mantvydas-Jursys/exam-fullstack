

function AddNewClient() {


    return (

        <div>

            <h1>Prideti nauja klienta</h1>

            <form>
                <label>
                    Vardas:
                    <input type="text" name="Vardas" placeholder="Vardas"/>
                </label>

                <label>
                    Pavarde:
                    <input type="text" name="Pavarde" placeholder="Pavarde"/>
                </label>

                <label>
                    Gimtadienis:
                    <input type="date" name="Gimtadienis" placeholder="Gimtadienis"/>
                </label>

                <label>
                    Telefonas:
                    <input type="number" name="Telefonas" maxLength={12} placeholder="Telefonas"/>
                </label>

                <label>
                    Kliento tipas?:
                    <input type="radio" name="Loyalus?" value="Paprastas" /> Paprastas
                    <input type="radio" name="Loyalus?" value="Loyalus"/> Loyalus
                </label>

                <input type="submit" value="Submit" />
            </form>


        </div>


    )

}

export default AddNewClient