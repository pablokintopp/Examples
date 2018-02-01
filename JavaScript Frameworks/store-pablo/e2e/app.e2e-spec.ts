import { StorePabloPage } from './app.po';

describe('store-pablo App', function() {
  let page: StorePabloPage;

  beforeEach(() => {
    page = new StorePabloPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
