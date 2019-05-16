import React from 'react';
import axios from 'axios';
import './App.css';

class App extends React.Component {
  state = {
    category: '',
    description: '',
    id: '',
    imgUrl: '',
    name: '',
    price: '',
    rate: '',
  }

  componentDidMount () {
    const urlParams = new URLSearchParams(window.location.search);
    const id = urlParams.get('id');
    this.getMedicineInfo(id);
  }

  getMedicineInfo = (id) => {
    if (!id) return;
    axios.get(`/OrchestrationAPI/products/${id}`)
      .then(({ data }) => {
        this.setState({
          ...this.state,
          ...data[0],
        })
        console.log(data);
      })
      .catch(err => console.log(err))
  }

  goBack = () => {
    window.history.go(-1);
  }

  render () {
    const { category, description, imgUrl, name, price, rate } = this.state;
    return (
      <div className="container">
        <button type="button" className="back" onClick={this.goBack}>
          {'<< Go Back'}
        </button>
        <button type="button" id="add_to_cartBtn" className="pull-right">
          <span
            className="glyphicon glyphicon-shopping-cart"
            aria-hidden="true"
          />
          &nbsp;&nbsp;Add to ShoppingCart
        </button>
        <h3 id="bookinfo_title"> </h3>
        <hr />
        <div className="row">
          <img
            src={imgUrl}
            id="bookinfo_img"
            className="col-xs-5 half-shrink"
            alt=""
          />
          <div className="col-xs-7 bookinfo_detail">
            <small id="bookinfo_author">
              Name: &nbsp;{name}
            </small>
            <br />
            <small>
              Price: &nbsp;{price}
            </small>
            <br />
            <small>
              Rate: &nbsp;{rate}
            </small>
            <br />
          </div>
        </div>
        <hr />
        <h3>Categories</h3>
        <p id="bookinfo_categories">{category}</p>
        <hr />
        <h3>Description</h3>
        <p id="bookinfo_description">{description}</p>
      </div>
    );
  }
}

export default App;
