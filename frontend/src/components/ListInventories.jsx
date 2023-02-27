import { Component } from "react";

class ListInventories extends Component {

    state = {
      inventories: []
    };
  
    async componentDidMount() {
      const response = await fetch('/inventories');
      const body = await response.json();
      this.setState({inventories: body});
    }
  
    render() {
      const {inventories} = this.state;
      return (
          <div className="App">
            <header className="App-header">
              {/* <img src={logo} className="App-logo" alt="logo" /> */}
              <div className="App-intro">
                <h2>Inventories</h2>
                {inventories.map(inventory =>
                    <div key={inventory.id}>
                      {inventory.name} ({inventory.mass}) 
                      {inventory.sector} {inventory.createdDate} 
                      {inventory.clients}
                    </div>
                )}
              </div>
            </header>
          </div>
      );
    }
  }
  export default ListInventories;