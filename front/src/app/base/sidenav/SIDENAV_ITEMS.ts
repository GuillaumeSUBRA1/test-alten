import { SidenavItem } from "app/base/sidenav/sidenav.model";

export const SIDENAV_ITEMS: SidenavItem[] = [
  {
    id: 'products',
    icon:'shopping-cart',
    labels: {
      en: "Product",
      fr: "Produits"
    },
    link: 'products'

  },
  {
    id: 'products-admin',
    icon:'users',
    labels: {
      en: "Admin",
      fr: "Admin"
    },
    link: 'products-admin'

  }

];