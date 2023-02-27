import { Component } from "react";

class ListClients extends Component {

    state = {
      clients: []
    };
  
    async componentDidMount() {
      const response = await fetch('/clients');
      const body = await response.json();
      this.setState({clients: body});
    }
  
    render() {
      const {clients} = this.state;
      return (
          <div className="App">
            <header className="App-header">
              {/* <img src={logo} className="App-logo" alt="logo" /> */}
              <div className="App-intro">
                <h2>Clients</h2>
                {clients.map(client =>
                    <div key={client.id}>
                      {client.name} ({client.surname}) {client.birthday} {client.phone} {client.isloyal}
                    </div>
                )}
              </div>
            </header>
          </div>
      );
    }
  }
  export default ListClients;