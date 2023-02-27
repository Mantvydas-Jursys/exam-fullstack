import './App.css';

import AddNewClient from './components/AddNewClient'
import AddNewInventory from './components/AddNewInventory';

import ListClients from './components/ListClients';
import ListInventories from './components/ListInventories';

function App() {
  return (
    <div className="App">
      
      <AddNewClient />

      <ListClients />

      <AddNewInventory />

      <ListInventories />


    </div>
  );
}

export default App;
